自定义View:
	
	思路: 一个View可以不需要其他的东西,但必须要有尺寸,拿狗来举个例子：只要是狗,就有它的高矮胖瘦等。   尺寸的确定在onMeasure中完成
		  但为了更好的去显示它,我们需要在onDraw来绘制.但有时系统提供给我们的属性不能满足我们的需求,我们可以自定义属性
	
	步骤：
		1,onMeasure
			根据 widthMeasureSpec 和 heightMeasureSpec的测量建议和实际需要测量出View的实际尺寸
		2,onDraw
			为动态的更新View,根据Paint和Draw在View上画出需要的视图
			
			细节：
				当在XML文件中使用Margin时有效;使用Padding时无效,需手动在onDraw中设置padding效果
				
		为了更好的去使用自定义,使用了自定义属性,自定义属性比较简单,这里就不啰嗦了		

自定义ViewGroup(ViewGroup是View的子类):
	
	思路：说白了就是为了将几个View去排列组合. 不仅要自定义自己,还要自定义孩子,所以需要onMeasure和onDraw还需要onLayout(排列组合子View)方法
	
	步骤：
		1,onMeasure
			测量自己及子View
		2,onLayout
			排列组合子View