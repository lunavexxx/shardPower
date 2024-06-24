<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}"
                class="slt">
          <el-form-item :label="contents.inputTitle == 1 ? '商户名称' : ''">
            <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" v-model="searchForm.shanghumingcheng"
                      clearable placeholder="商户名称" prefix-icon="el-icon-search"></el-input>
            <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" v-model="searchForm.shanghumingcheng"
                      clearable placeholder="商户名称" suffix-icon="el-icon-search"></el-input>
            <el-input v-if="contents.inputIcon == 0" v-model="searchForm.shanghumingcheng" clearable
                      placeholder="商户名称"></el-input>
          </el-form-item>
          <el-form-item :label="contents.inputTitle == 1 ? '用户姓名' : ''">
            <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" v-model="searchForm.yonghuxingming"
                      clearable placeholder="用户姓名" prefix-icon="el-icon-search"></el-input>
            <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" v-model="searchForm.yonghuxingming"
                      clearable placeholder="用户姓名" suffix-icon="el-icon-search"></el-input>
            <el-input v-if="contents.inputIcon == 0" v-model="searchForm.yonghuxingming" clearable
                      placeholder="用户姓名"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search"
                       type="success" @click="search()">{{ contents.searchBtnFont == 1 ? '查询' : '' }}
            </el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success"
                       @click="search()">{{ contents.searchBtnFont == 1 ? '查询' : '' }}<i
                class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">
              {{ contents.searchBtnFont == 1 ? '查询' : '' }}
            </el-button>
          </el-form-item>
        </el-row>
        <el-row :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}"
                class="ad">
          <el-form-item>
            <el-button
                v-if="isAuth('zulindingdan','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
                icon="el-icon-plus"
                type="success"
                @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1 ? '新增' : '' }}
            </el-button>
            <el-button
                v-if="isAuth('zulindingdan','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
                type="success"
                @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1 ? '新增' : '' }}<i class="el-icon-plus el-icon--right"/></el-button>
            <el-button
                v-if="isAuth('zulindingdan','新增') && contents.btnAdAllIcon == 0"
                type="success"
                @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1 ? '新增' : '' }}
            </el-button>
            <el-button
                v-if="isAuth('zulindingdan','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1 && contents.tableSelection"
                :disabled="dataListSelections.length <= 0"
                icon="el-icon-delete"
                type="danger"
                @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1 ? '删除' : '' }}
            </el-button>
            <el-button
                v-if="isAuth('zulindingdan','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2 && contents.tableSelection"
                :disabled="dataListSelections.length <= 0"
                type="danger"
                @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1 ? '删除' : '' }}<i class="el-icon-delete el-icon--right"/></el-button>
            <el-button
                v-if="isAuth('zulindingdan','删除') && contents.btnAdAllIcon == 0 && contents.tableSelection"
                :disabled="dataListSelections.length <= 0"
                type="danger"
                @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1 ? '删除' : '' }}
            </el-button>


          </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table v-if="isAuth('zulindingdan','查看')" v-loading="dataListLoading" :border="contents.tableBorder"
                  :cell-style="cellStyle" :data="dataList"
                  :fit="contents.tableFit"
                  :header-cell-style="headerCellStyle"
                  :header-row-style="headerRowStyle"
                  :row-style="rowStyle"
                  :show-header="contents.tableShowHeader"
                  :size="contents.tableSize"
                  :stripe="contents.tableStripe"
                  :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                  class="tables"
                  @selection-change="selectionChangeHandler">
          <el-table-column v-if="contents.tableSelection"
                           align="center"
                           header-align="center"
                           type="selection"
                           width="50">
          </el-table-column>
          <el-table-column v-if="contents.tableIndex" label="索引" type="index" width="50"/>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="租赁编号"
                           prop="zulinbianhao">
            <template slot-scope="scope">
              {{ scope.row.zulinbianhao }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="充电宝编号"
                           prop="chongdianbaobianhao">
            <template slot-scope="scope">
              {{ scope.row.chongdianbaobianhao }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable" header-align="center"
                           label="图片"
                           prop="tupian"
                           width="200">
            <template slot-scope="scope">
              <div v-if="scope.row.tupian">
                <img :src="scope.row.tupian.split(',')[0]" height="100" width="100">
              </div>
              <div v-else>无图片</div>
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="区域"
                           prop="quyu">
            <template slot-scope="scope">
              {{ scope.row.quyu }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="商户编号"
                           prop="shanghubianhao">
            <template slot-scope="scope">
              {{ scope.row.shanghubianhao }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="商户名称"
                           prop="shanghumingcheng">
            <template slot-scope="scope">
              {{ scope.row.shanghumingcheng }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="每小时费用"
                           prop="meixiaoshifeiyong">
            <template slot-scope="scope">
              {{ scope.row.meixiaoshifeiyong }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="押金"
                           prop="yajin">
            <template slot-scope="scope">
              {{ scope.row.yajin }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="开始时间"
                           prop="kaishishijian">
            <template slot-scope="scope">
              {{ scope.row.kaishishijian }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="用户账号"
                           prop="yonghuzhanghao">
            <template slot-scope="scope">
              {{ scope.row.yonghuzhanghao }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="用户姓名"
                           prop="yonghuxingming">
            <template slot-scope="scope">
              {{ scope.row.yonghuxingming }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" :sortable="contents.tableSortable"
                           header-align="center"
                           label="用户手机"
                           prop="yonghushouji">
            <template slot-scope="scope">
              {{ scope.row.yonghushouji }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center"
                           label="操作"
                           width="300">
            <template slot-scope="scope">
              <el-button
                  v-if="isAuth('zulindingdan','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1"
                  icon="el-icon-tickets" size="mini" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
                {{ contents.tableBtnFont == 1 ? '详情' : '' }}
              </el-button>
              <el-button
                  v-if="isAuth('zulindingdan','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2"
                  size="mini" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
                {{ contents.tableBtnFont == 1 ? '详情' : '' }}<i class="el-icon-tickets el-icon--right"/></el-button>
              <el-button v-if="isAuth('zulindingdan','查看') && contents.tableBtnIcon == 0" size="mini" type="success"
                         @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1 ? '详情' : '' }}
              </el-button>

              <el-button
                  v-if="isAuth('zulindingdan','归还') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1"
                  icon="el-icon-tickets" size="mini" type="success"
                  @click="guihaidingdanCrossAddOrUpdateHandler(scope.row,'cross')">
                {{ contents.tableBtnFont == 1 ? '归还' : '' }}
              </el-button>
              <el-button
                  v-if="isAuth('zulindingdan','归还') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2"
                  size="mini" type="success" @click="guihaidingdanCrossAddOrUpdateHandler(scope.row,'cross')">
                {{ contents.tableBtnFont == 1 ? '归还' : '' }}<i class="el-icon-tickets el-icon--right"/></el-button>
              <el-button v-if="isAuth('zulindingdan','归还') && contents.tableBtnIcon == 0" size="mini" type="success"
                         @click="guihaidingdanCrossAddOrUpdateHandler(scope.row,'cross')">
                {{ contents.tableBtnFont == 1 ? '归还' : '' }}
              </el-button>

              <el-button
                  v-if="isAuth('zulindingdan','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1"
                  icon="el-icon-edit" size="mini" type="primary" @click="addOrUpdateHandler(scope.row.id)">
                {{ contents.tableBtnFont == 1 ? '修改' : '' }}
              </el-button>
              <el-button
                  v-if="isAuth('zulindingdan','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2"
                  size="mini" type="primary" @click="addOrUpdateHandler(scope.row.id)">
                {{ contents.tableBtnFont == 1 ? '修改' : '' }}<i class="el-icon-edit el-icon--right"/></el-button>
              <el-button v-if="isAuth('zulindingdan','修改') && contents.tableBtnIcon == 0" size="mini" type="primary"
                         @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1 ? '修改' : '' }}
              </el-button>


              <el-button
                  v-if="isAuth('zulindingdan','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1"
                  icon="el-icon-delete" size="mini" type="danger" @click="deleteHandler(scope.row.id)">
                {{ contents.tableBtnFont == 1 ? '删除' : '' }}
              </el-button>
              <el-button
                  v-if="isAuth('zulindingdan','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2"
                  size="mini" type="danger" @click="deleteHandler(scope.row.id)">
                {{ contents.tableBtnFont == 1 ? '删除' : '' }}<i class="el-icon-delete el-icon--right"/></el-button>
              <el-button v-if="isAuth('zulindingdan','删除') && contents.tableBtnIcon == 0" size="mini" type="danger"
                         @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1 ? '删除' : '' }}
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
            :background="contents.pageBtnBG"
            :current-page="pageIndex"
            :layout="layouts"
            :page-size="Number(contents.pageEachNum)"
            :page-sizes="[10, 20, 50, 100]"
            :small="contents.pageStyle"
            :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
            :total="totalPage"
            class="pagination-content"
            clsss="pages"
            @size-change="sizeChangeHandle"
            @current-change="currentChangeHandle"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" ref="addOrUpdate" :parent="this"></add-or-update>

    <guihaidingdan-cross-add-or-update v-if="guihaidingdanCrossAddOrUpdateFlag" ref="guihaidingdanCrossaddOrUpdate"
                                       :parent="this"></guihaidingdan-cross-add-or-update>


  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
import guihaidingdanCrossAddOrUpdate from "../guihaidingdan/add-or-update";

export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form: {},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag: false,
      guihaidingdanCrossAddOrUpdateFlag: false,
      contents: {
        "searchBtnFontColor": "rgba(0, 0, 0, 1)",
        "pagePosition": "1",
        "inputFontSize": "14px",
        "inputBorderRadius": "4px",
        "tableBtnDelFontColor": "rgba(0, 0, 0, 1)",
        "tableBtnIconPosition": "1",
        "searchBtnHeight": "40px",
        "inputIconColor": "#C0C4CC",
        "searchBtnBorderRadius": "4px",
        "tableStripe": true,
        "btnAdAllWarnFontColor": "rgba(0, 0, 0, 1)",
        "tableBtnDelBgColor": "rgba(255, 255, 204, 1)",
        "searchBtnIcon": "1",
        "tableSize": "medium",
        "searchBtnBorderStyle": "solid",
        "tableSelection": true,
        "searchBtnBorderWidth": "1px",
        "tableContentFontSize": "14px",
        "searchBtnBgColor": "rgba(36, 194, 205, 1)",
        "inputTitleSize": "14px",
        "btnAdAllBorderColor": "#DCDFE6",
        "pageJumper": true,
        "btnAdAllIconPosition": "1",
        "searchBoxPosition": "1",
        "tableBtnDetailFontColor": "rgba(0, 0, 0, 1)",
        "tableBtnHeight": "40px",
        "pagePager": true,
        "searchBtnBorderColor": "#DCDFE6",
        "tableHeaderFontColor": "#909399",
        "inputTitle": "1",
        "tableBtnBorderRadius": "4px",
        "btnAdAllFont": "0",
        "btnAdAllDelFontColor": "rgba(0, 0, 0, 1)",
        "tableBtnIcon": "1",
        "btnAdAllHeight": "40px",
        "btnAdAllWarnBgColor": "rgba(102, 102, 153, 1)",
        "btnAdAllBorderWidth": "1px",
        "tableStripeFontColor": "#606266",
        "tableBtnBorderStyle": "solid",
        "inputHeight": "40px",
        "btnAdAllBorderRadius": "4px",
        "btnAdAllDelBgColor": "rgba(255, 255, 204, 1)",
        "pagePrevNext": true,
        "btnAdAllAddBgColor": "rgba(36, 194, 205, 1)",
        "searchBtnFont": "0",
        "tableIndex": true,
        "btnAdAllIcon": "1",
        "tableSortable": true,
        "pageSizes": true,
        "tableFit": true,
        "pageBtnBG": false,
        "searchBtnFontSize": "14px",
        "tableBtnEditBgColor": "rgba(102, 102, 153, 1)",
        "inputBorderWidth": "1px",
        "inputFontPosition": "1",
        "inputFontColor": "#333",
        "pageEachNum": 10,
        "tableHeaderBgColor": "#fff",
        "inputTitleColor": "#333",
        "btnAdAllBoxPosition": "1",
        "tableBtnDetailBgColor": "rgba(36, 194, 205, 1)",
        "inputIcon": "1",
        "searchBtnIconPosition": "2",
        "btnAdAllFontSize": "10px",
        "inputBorderStyle": "solid",
        "inputBgColor": "#fff",
        "pageStyle": false,
        "pageTotal": true,
        "btnAdAllAddFontColor": "rgba(0, 0, 0, 1)",
        "tableBtnFont": "1",
        "tableContentFontColor": "#606266",
        "inputBorderColor": "#DCDFE6",
        "tableShowHeader": true,
        "tableBtnFontSize": "10px",
        "tableBtnBorderColor": "#DCDFE6",
        "inputIconPosition": "2",
        "tableBorder": true,
        "btnAdAllBorderStyle": "solid",
        "tableBtnBorderWidth": "0px",
        "tableStripeBgColor": "#F5F7FA",
        "tableBtnEditFontColor": "rgba(0, 0, 0, 1)",
        "tableAlign": "center"
      },
      layouts: '',


    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g, '');
    }
  },
  components: {
    AddOrUpdate,
    guihaidingdanCrossAddOrUpdate,
  },
  methods: {
    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
          let textAlign = 'left'
          if (this.contents.inputFontPosition == 2) textAlign = 'center'
          if (this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if (this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(() => {
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
            el.style.lineHeight = this.contents.inputHeight
          })
        }, 10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    rowStyle({row, rowIndex}) {
      if (rowIndex % 2 == 1) {
        if (this.contents.tableStripe) {
          return {color: this.contents.tableStripeFontColor}
        }
      } else {
        return ''
      }
    },
    cellStyle({row, rowIndex}) {
      if (rowIndex % 2 == 1) {
        if (this.contents.tableStripe) {
          return {backgroundColor: this.contents.tableStripeBgColor}
        }
      } else {
        return ''
      }
    },
    headerRowStyle({row, rowIndex}) {
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({row, rowIndex}) {
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange() {
      // this.$nextTick(()=>{
      //   setTimeout(()=>{
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDetailFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnEditFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDelFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
      //     })

      //   }, 50)
      // })
    },
    // 分页
    contentPageStyleChange() {
      let arr = []

      if (this.contents.pageTotal) arr.push('total')
      if (this.contents.pageSizes) arr.push('sizes')
      if (this.contents.pagePrevNext) {
        arr.push('prev')
        if (this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if (this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

    guihaidingdanCrossAddOrUpdateHandler(row, type) {
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.guihaidingdanCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj', row);
      this.$storage.set('crossTable', 'zulindingdan');
      this.$nextTick(() => {
        this.$refs.guihaidingdanCrossaddOrUpdate.init(row.id, type);
      });
    },
    init() {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
      if (this.searchForm.shanghumingcheng != '' && this.searchForm.shanghumingcheng != undefined) {
        params['shanghumingcheng'] = '%' + this.searchForm.shanghumingcheng + '%'
      }
      if (this.searchForm.yonghuxingming != '' && this.searchForm.yonghuxingming != undefined) {
        params['yonghuxingming'] = '%' + this.searchForm.yonghuxingming + '%'
      }
      this.$http({
        url: "zulindingdan/page",
        method: "get",
        params: params
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id, type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if (type != 'info') {
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id, type);
      });
    },
    // 查看评论
    // 下载
    download(file) {
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
          ? [Number(id)]
          : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "zulindingdan/delete",
          method: "post",
          data: ids
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
  }

};
</script>
<style lang="scss" scoped>
.slt {
  margin: 0 !important;
  display: flex;
}

.ad {
  margin: 0 !important;
  display: flex;
}

.pages {
  & /deep/ el-pagination__sizes {
    & /deep/ el-input__inner {
      height: 22px;
      line-height: 22px;
    }
  }
}


.el-button + .el-button {
  margin: 0;
}

.tables {
  & /deep/ .el-button--success {
    height: 40px;
    color: rgba(0, 0, 0, 1);
    font-size: 10px;
    border-width: 0px;
    border-style: solid;
    border-color: #DCDFE6;
    border-radius: 4px;
    background-color: rgba(36, 194, 205, 1);
  }

  & /deep/ .el-button--primary {
    height: 40px;
    color: rgba(0, 0, 0, 1);
    font-size: 10px;
    border-width: 0px;
    border-style: solid;
    border-color: #DCDFE6;
    border-radius: 4px;
    background-color: rgba(102, 102, 153, 1);
  }

  & /deep/ .el-button--danger {
    height: 40px;
    color: rgba(0, 0, 0, 1);
    font-size: 10px;
    border-width: 0px;
    border-style: solid;
    border-color: #DCDFE6;
    border-radius: 4px;
    background-color: rgba(255, 255, 204, 1);
  }

  & /deep/ .el-button {
    margin: 4px;
  }
}

</style>
