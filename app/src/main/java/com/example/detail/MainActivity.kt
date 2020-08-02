package com.example.detail

import android.app.ActionBar
import android.icu.text.RelativeDateTimeFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft

/*
    屏幕默认情况下，在代码中写的尺寸都是pix 像素
    代码中写 100 = 100px
    运行起来之后在手机上显示的也是100px
    但是手机有不同分辨率（屏幕密度） Density
     分辨率为1 则对应像素为100dp * 1 = 100px
     分辨率为2 则对应像素为 50dp * 2 = 100px
     分辨率为5 则对应像素为 20dp * 5 = 100

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //用代码构建界面
        //MainActivity 继承于 Context

        //addLinerLayoutjava()

        //addLinearLayoutKotlin()


         //手动创建RelativeLayout容器，进行手动布局
        //addRelativeLayout()

        //手动创建ConstraintLayout容器， 进行手动布局
        addConstraintLayout()
    }

    private fun addConstraintLayout(){

        val constraintLayout = ConstraintLayout(this).apply {
            id = R.id.mContainer
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            background =  getDrawable(R.color.colorPrimary)
            setContentView(this)
        }

        //添加子控件
        ImageView(this).apply {
            id = R.id.mHeader
            layoutParams = ConstraintLayout.LayoutParams(dptopix(120),dptopix(90)).apply {
                //左边和父容器左边对齐
                leftToLeft = R.id.mContainer
                //顶部和父容器顶部对齐
                topToTop = R.id.mContainer
                setMargins(dptopix(10),dptopix(10),0,0)

            }
            setImageResource(R.drawable.ic_launcher_background)
            scaleType = ImageView.ScaleType.CENTER_CROP
            constraintLayout.addView(this)
        }

        //添加标题
        TextView(this).apply {
            id = R.id.mTitle
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT).apply {
                leftToRight = R.id.mHeader
                rightToRight = R.id.mContainer
                topToTop = R.id.mHeader
                bottomToBottom = R.id.mHeader
                setMargins(dptopix(10),0,dptopix(10),0)
            }
            text =  "美国计划在购买4艘医疗船用以抗击疫情"
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            constraintLayout.addView(this)
        }

        //添加最后的文本
        TextView(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT).apply {
                leftToLeft = R.id.mHeader
                rightToRight = R.id.mTitle
                topToBottom = R.id.mHeader
                bottomToBottom = R.id.mContainer
                setMargins(0,dptopix(10),0,0)
            }
            text =  "“世界很复杂，百度更懂你”，百度百科旨在创造一个涵盖各领域知识的中文信息收集平台。百度百科强调用户的参与和奉献精神，充分调动互联网用户的力量，汇聚上亿用户的头脑智慧，积极进行交流和分享。同时，百度百科实现与百度搜索、百度知道的结合，从不同的层次上满足用户对信息的需求。"
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            constraintLayout.addView(this)

        }
    }
    private fun addRelativeLayout(){
        //创建RelativeLayout容器
        val relativeLayout = RelativeLayout(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT)
            //添加id
            id = R.id.mContainer
            //设置背景颜色
            background = getDrawable(R.color.colorPrimaryDark)
            //将这个容器视图添加到Activity中
            setContentView(this)
        }

        //添加图片
        ImageView(this).apply {
            //给控件添加id
            id = R.id.mHeader
            layoutParams = RelativeLayout.LayoutParams(dptopix(120),dptopix(90)).apply{
                setMargins(dptopix(10),dptopix(10),0,0) }
            setImageResource(R.drawable.ic_launcher_background)
            scaleType = ImageView.ScaleType.CENTER_CROP
            relativeLayout.addView(this)
        }

        //添加标题
        TextView(this).apply {
            //添加id
            id = R.id.mTitle
            layoutParams = RelativeLayout.LayoutParams(0,0).apply {
                //设置和其他控件的相对关系
                //1、和头像的相对关系
                addRule(RelativeLayout.RIGHT_OF,R.id.mHeader)
                //和父容器右边对其
                addRule(RelativeLayout.ALIGN_PARENT_END,R.id.mContainer)
                //和头像顶部对齐
                addRule(RelativeLayout.ALIGN_TOP,R.id.mHeader)
                //和头像底部对齐
                addRule(RelativeLayout.ALIGN_BOTTOM, R.id.mHeader)
                //和头像左边的间距
                marginStart = dptopix(10)
                //和父容器右边的间距
                marginEnd = dptopix(10)
            }
            text =  "美国计划在购买4艘医疗船用以抗击疫情"
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            relativeLayout.addView(this)
        }
        //添加内容
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,0).apply {
                //设置控件之间的相对关系
                //和头像的相对关系 在头像的下方
                addRule(RelativeLayout.BELOW,R.id.mHeader)
                //和头像的左边对齐
                addRule(RelativeLayout.ALIGN_START,R.id.mHeader)
                //和标题右边对其
                addRule(RelativeLayout.ALIGN_END,R.id.mTitle)
                //和父容器底部对齐
                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,R.id.mContainer)
                //文本和父容器左右间距
                setMargins(0,dptopix(10),0,0)
            }
            text =  "“世界很复杂，百度更懂你”，百度百科旨在创造一个涵盖各领域知识的中文信息收集平台。百度百科强调用户的参与和奉献精神，充分调动互联网用户的力量，汇聚上亿用户的头脑智慧，积极进行交流和分享。同时，百度百科实现与百度搜索、百度知道的结合，从不同的层次上满足用户对信息的需求。"
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            relativeLayout.addView(this)
        }
    }
    private fun addLinearLayoutKotlin(){
        //创建容器
        val container = LinearLayout(this).apply {
            //设置宽高
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )

            //方向
            orientation = LinearLayout.VERTICAL

            //设置颜色
            background = getDrawable(R.color.colorAccent)

        }.also { setContentView(it)}

        //创建第一个子控件 为 横向布局的 linearLayout
        LinearLayout(this).apply {

            //设置宽高
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,dptopix(100))
            //方向
            orientation = LinearLayout.HORIZONTAL
            //设置颜色
            background = getDrawable(R.color.colorPrimary)
            //当前这个子控件添加到父容器中
            container.addView(this)
        }.apply {
            //添加图片
            ImageView(this@MainActivity).apply {
                //宽高
                layoutParams = LinearLayout.LayoutParams(
                    dptopix(120),
                    LinearLayout.LayoutParams.MATCH_PARENT)
                //设置图片资源
                setImageResource(R.drawable.ic_launcher_background)
                //设置填充模式
                scaleType = ImageView.ScaleType.CENTER_CROP
                //添加到容器中
                addView(this)
            }
            //添加文本
            TextView(this@MainActivity).apply {
                //设置宽高
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT).apply {
                    weight = 1f
                    setMargins(dptopix(10),dptopix(10),dptopix(10),dptopix(10))
                }
                text = " 美国计划在买4搜医疗船抗击疫情"
                setTextColor(getColor(R.color.colorWhite))
                textSize = 20f
                addView(this)
            }
        }

        //创建第二个子控件 TextView
        TextView(this).apply {
            //设置宽高
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT).apply {
                setMargins(dptopix(10),dptopix(10),dptopix(10),dptopix(10))
            }

            text = "“世界很复杂，百度更懂你”，百度百科旨在创造一个涵盖各领域知识的中文信息收集平台。百度百科强调用户的参与和奉献精神，充分调动互联网用户的力量，汇聚上亿用户的头脑智慧，积极进行交流和分享。同时，百度百科实现与百度搜索、百度知道的结合，从不同的层次上满足用户对信息的需求。 "
            setTextColor(getColor(R.color.colorWhite))
            textSize = 20f
            container.addView(this)
        }

    }
    //获取屏幕的密度 获取设备信息
    fun dptopix(dp: Int) : Int{
        return(resources.displayMetrics.density * dp).toInt()
    }

   private fun addLinerLayoutjava(){

        //1、创建容器 ——>承载内容 LinerLayout RelativeLayout  constraintLayout

       val linearlayout =  LinearLayout(this)
        //2、给容器设置布局参数
        linearlayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)

        //3、设置布局方向
        linearlayout.orientation = LinearLayout.VERTICAL

        //背景颜色
        linearlayout.background  = getDrawable(R.color.colorAccent)

        //4、添加容器到activity上
        setContentView(linearlayout)
    }


}