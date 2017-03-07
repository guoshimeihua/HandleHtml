package com.bruce.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bruce on 17/3/5.
 */
public class HandleHtml {
    public static void main(String[] args) throws IOException {
        String path = "/Users/Bruce/Documents/wechat";
        File file = new File(path+"/六大设计原则(读书笔记).html");
        Document document = Jsoup.parse(file, "utf-8");
        String content = document.toString();
        System.out.println("转换后的字符串: "+content);

        // 清楚样式
        int begin = content.indexOf("<style>");
        int end = content.indexOf("</style>");
        StringBuffer stringBuffer = new StringBuffer(content);
        stringBuffer = stringBuffer.replace(begin+7, end, "");
        String result = new String(stringBuffer);
        System.out.println("样式全部清除掉: "+result);

        String replaceStyle = convertHtmlToString(path+"/replace_style.html");
        String footer = convertHtmlToString(path+"/footer.html");

        result = replace(result, "<style></style>", replaceStyle);
        result = replace(result, "</html>", footer);
        result = replaceAll(result, "<h3>", "<section><h3>");
        result = replaceAll(result, "</h3>", "</h3></section>");
        System.out.println("=============全部替换完成后的html字符串===============");
        System.out.println(result);

        StringSelection selection = new StringSelection(result);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    private static String convertHtmlToString(String path) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                contentBuilder.append(str);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    // 替换指定的
    private static String replace(String string, String origin, String replace) {
        return string.replace(origin, replace);
    }

    // 替换全部
    private static String replaceAll(String string, String regx, String replace) {
        return string.replaceAll(regx, replace);
    }
}

