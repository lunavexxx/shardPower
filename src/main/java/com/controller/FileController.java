package com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ConfigEntity;
import com.entity.EIException;
import com.service.ConfigService;
import com.utils.R;

/**
 * 上传文件映射表
 */
@RestController
@RequestMapping("file")
@SuppressWarnings({"unchecked","rawtypes"})
public class FileController{
	@Autowired
    private ConfigService configService;
	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	public R upload(@RequestParam("file") MultipartFile file, String type,HttpServletRequest request) throws Exception {
		if (file.isEmpty()) {
			throw new EIException("上传文件不能为空");
		}
		String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
		String fileName = new Date().getTime()+"."+fileExt;


		// 本地
		File dest = new File("C:\\Users\\30728\\Desktop\\end\\2013040919秦乐朋-源代码\\src\\main\\webapp\\upload\\"+fileName);
		file.transferTo(dest);

		// tomcat
		File dest1 = new File(request.getSession().getServletContext().getRealPath("/upload")+"/"+fileName);
		Files.copy(dest.toPath(), dest1.toPath(), StandardCopyOption.REPLACE_EXISTING);

		if(StringUtils.isNotBlank(type) && type.equals("1")) {
			ConfigEntity configEntity = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "faceFile"));
			if(configEntity==null) {
				configEntity = new ConfigEntity();
				configEntity.setName("faceFile");
				configEntity.setValue(fileName);
			} else {
				configEntity.setValue(fileName);
			}
			configService.insertOrUpdate(configEntity);
		}
		return R.ok().put("file", fileName);
	}
	
	/**
	 * 下载文件
	 */
	@IgnoreAuth
	@RequestMapping("/download")
	public void download(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) {
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("/upload")+"/"+fileName);
			if (file.exists()) {
				response.reset();
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName+"\"");
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setContentType("application/octet-stream; charset=UTF-8");
				IOUtils.write(FileUtils.readFileToByteArray(file), response.getOutputStream());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
