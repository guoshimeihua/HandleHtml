> 经常写文章的人，会发现微信公众号自带的编辑器不是很好用，用它来排版一篇写好的文章，往往要花费一两个小时，浪费了大量的时间，最后的排版效果也不是那么好。本篇文章将介绍如何利用markdown、css、html来排版出自己微信公众号的样式，排版时间只需要几秒钟就可以完成。

### 认识Markdown

> Markdown是一种轻量级标记语言，它允许人们使用易读易写的纯文本格式编写文档，然后转换成有效的HTML文档。

Markdown的语法很简单，学习5-10分钟就可以熟练使用了。比如：

	# 这是 H1 一级标题
	## 这是H2 二级标题
	### 这是H3 三级标题

Markdown对代码块的处理也非常好，如下所示：

	if (request.getType == 1) {
      // 交给对象A处理
    }else if (request.getType == 2) {
      // 交给对象B处理     
    }else if (request.getType == 3) {
      // 交给对象C处理    
    }else {
      // 不做任何处理
    }
    
关于Markdown具体的使用，可以参考下面这篇文章：

[Markdown 具体使用说明](http://wowubuntu.com/markdown/)

正是由于Markdown使用比较简单，能够让我们把更多的精力投入到文章的内容上，而不是浪费在排版上面。下面给大家推荐几款免费的Markdown编辑器，如下：

Windows平台

* [MarkdownPad](http://markdownpad.com/)
* [MarkPad](http://code52.org/DownmarkerWPF/)

Mac平台

* [Mou](http://25.io/mou/)

### 如何利用css、html来排版呢？

对于没有编程基础的人，这似乎是很难做到的，但我还是建议你学习一下简单的css、html的相关知识，记得**简单学一下就可以了**。为什么简单学习一些就可以了呢？**因为好多公众号上面的样式都是可以直接copy过来的。**下面通过一个简单的例子告诉大家如何去copy别人现成的样式。

**第一步：**把刚才用markdown写好的文章，通过编辑器导出成html格式，保存在本地。以Mou为例如下图：

![1-1 export.png](http://upload-images.jianshu.io/upload_images/416556-dad16d14da407fe1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

用Chrome浏览器打开刚才导出的html文件，另外也选择用文本编辑器(比如Sublime Text)打开html文件，方便你修改与查找html源码。

**第二步：**把你想copy样式的公众号中的一篇文章，在电脑上用Chrome浏览器给打开。比如你想拷贝这样一个样式，如下图：

![1-2 copystyle.png](http://upload-images.jianshu.io/upload_images/416556-d900b39bc57cc8de.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

样式就是标题居中、带下划线、有张背景图，怎么copy呢？很简单的，点击鼠标右键选择检查，就会看到如下图的内容：

![1-3 check.png](http://upload-images.jianshu.io/upload_images/416556-ef9ec6d32d11f396.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![1-4 check2.png](http://upload-images.jianshu.io/upload_images/416556-7d02be45fe600b81.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

重点看我用红线画出的区域，从1红色区域我们可以看出文章标题那块使用了两个html标记：section与span，section可以理解为一个块，一个区域，span就可以理解为一个文字块，用来填写文字的。理解了这些，在看2红色区域里面有一个background后面自带url，就可以猜测应该就是标题后面的背景图了，为了验证下，我们background前面的复选框给取消掉，如下图所示：

![1-5 check3.png](http://upload-images.jianshu.io/upload_images/416556-09af1cbfb7c0407a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

取消掉后，我们会发现标题后面的背景图消失了，就证明了我们的猜测。采用同样的方法可以找到border-bottom就是标题的下划线，color就是标题的颜色。

**第三步：**到这一步，你已经知道了如何去查看别人的样式了，那如何让自己的标题也变成这个样式呢？举个例子，比如把h3标题(三级标题)变成刚才的样式。在Sublime Text先找到h3标记，如下所示：

	<h3>repo换源</h3>
	
改成如下：

	<section><h3>repo换源</h3></section>

这就相当于完成步骤2中1红色区域的部分了，把h3标题放在section块中。再找到h3样式标记，如下所示：

	h3 {
  	  font-size: 18px; }
  	  
改成如下：

	section {
  	  display: block;
      text-align: center; }

	h3 {
  	  font-size: 18px;
      color: #3c70c6; 
      border-bottom: 2px solid #1b5fa0;
      text-align: center;
      display: inline-block;}

修改完成后，点击保存，刷新用Chrome打开的页面，效果如下：

![1-6 check4.png](http://upload-images.jianshu.io/upload_images/416556-187adf31e6652e64.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

通过刚才的3个步骤，基本上知道了如何去copy别人的样式，剩下的就是多试几次，最终调出你想要的样式。**本人微信公众号样式源码会在文章末尾提供一个链接供大家去下载。**

### 如何将html源码转换成富文本呢？

想要在微信公众号上正确地显示调好样式的文章，我们还需要**将html源码转换成富文本**，怎么进行转换呢？打开[WangEditor](http://www.wangeditor.com/)，然后点击源码，把html源码粘贴到这里，然后在点击源码就能够让html源码转换成富文本了。如下图所示：

![1-7 check5.png](http://upload-images.jianshu.io/upload_images/416556-c6b72cb88b32bf95.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

转换后的效果如下：

![1-8 check6.png](http://upload-images.jianshu.io/upload_images/416556-1454c035273f1b7a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

最后，也是最重要的一步，复制全部的富文本，粘贴到微信公众号后台，然后**发送到自己手机上进行预览，看下调整好的样式在手机上能否正确显示，因为微信公众号对部分css样式是不支持的，这个就需要自己不断进行调试了。**分享一下自己遇到的两个坑：

* 代码块显示不正确，没有背景色，字体颜色也没有发生变化。
* 无序列表和有序列表行与行之间没有空隙。

如图所示：

![1-9 check7.jpeg](http://upload-images.jianshu.io/upload_images/416556-dba83e08ce49767d.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

针对代码块显示不正确，查了许多资料，最后发现采用Markhere中代码块的css样式可以把这个问题给完美解决，css样式如下：

	pre, code {
  	  font-size: 0.85em;
  	  font-family: Consolas, Inconsolata, Courier, monospace; }

	code {
      margin: 0 0.15em;
      padding: 0 0.3em;
      white-space: pre-wrap;
      border: 1px solid #EAEAEA;
      background-color: #323232;
      border-radius: 3px;
      display: inline; }

	pre {
  	  font-size: 1em;
      line-height: 1.2em; }

	pre code {
  	  background-color: #323232;
  	  color: #5baceb;
  	  white-space: pre;
  	  overflow: auto;
  	  border-radius: 3px;
  	  border: 1px solid #CCC;
  	  padding: 0.5em 0.7em;
  	  display: block !important; }

针对列表的问题，只需要把样式改成如下：

	li {
  	  margin: 0.5em 0; }
  	  
  	# 改成如下
  	li {
  	  margin: 0.5em 0;
  	  font-size: 14px; }

**注意：样式全部显示正确后，要记录下自己都修改了哪些样式，在后面将会用程序来自动进行替换的。**

### 如何用程序实现html样式自动转换呢？

前面我们已经完成了样式的全部调整，如果每篇文章都调整一次样式，对我们来说也是很浪费时间的，我们可以用程序自动来处理样式的调整，**程序的核心思想就是replace(替换)**。在进行替换前，首先要把html里面的源代码读取出来并转换成字符串的形式，使用Java语言中对文件的操作即可做到这一点，代码如下：

	File file = new File("/Users/Bruce/Desktop/good.html");
    StringBuilder fileContents = new StringBuilder((int)file.length());
    Scanner scanner = new Scanner(file);
    String lineSeparator = System.getProperty("line.separator");

    try {
      while(scanner.hasNextLine()) {
        fileContents.append(scanner.nextLine() + lineSeparator);
      }
      System.out.println(fileContents.toString());
    } finally {
      scanner.close();
    }

代码中特别要**注意把行的分隔符给取出来，然后拼接在每读取一行的后面**，这样保证在转换的过程中换行符不会丢失，否则有可能在微信公众号上显示不正确，比如代码块的显示。**完整的转换程序，会在文章末尾提供链接地址供大家下载。**

### 其他

在写这篇文章之前，上网找到了不少免费的微信公众号编辑器，基本上都是提供了一些模板来让你进行选择，比如96微信编辑器，不能够提供对Markdown文本进行转换的。最后找到一款MarkEditor软件，可以把Markdown文本转换成微信公众号的样式，但是这款软件是收费的，就放弃了。最重要的一点是这些软件提供的样式不是自己喜欢的，所以才有了这篇文章的出现。**技术人就应该用技术来让自己的生活变得更美好哈。**

### 总结

**技术是用来服务生活的，作为一名技术人员，我们应该用技术的思维去让我们的生活更美好，应该培养自己的技术思维去解决现实生活中碰到的问题，也许你恰好解决大家生活中普遍遇到的问题，并且还没有人用技术来解决此问题，那么恭喜你了，你就可以让自己手中的技术变现，也可以找到自己的一个创业方向了。言归正传，本文的思路如下图所示：

![1-10 mind.png](http://upload-images.jianshu.io/upload_images/416556-11ead74c73142327.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 参考文章以及下载地址

http://mp.weixin.qq.com/s?__biz=MjM5ODQwMjA4MA==&mid=2649293603&idx=1&sn=57f38200555dcba76d6358594416c089&scene=19#wechat_redirect

http://www.jianshu.com/p/b09125018c04

http://wowubuntu.com/markdown/

https://segmentfault.com/a/1190000004198301

### 国士梅花
关注国士梅花，技术路上与你陪伴。

![微信公众号](http://upload-images.jianshu.io/upload_images/416556-34d2366fbc81b9be.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)