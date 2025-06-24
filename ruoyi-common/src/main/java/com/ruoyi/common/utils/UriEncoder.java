package com.ruoyi.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 包名：com.ruoyi.common.utils
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-06-12 22:13
 **/
public class UriEncoder {

    public static String encodeChineseInUrl(String url) throws UnsupportedEncodingException {
        // 按路径分隔符拆分
        String[] parts = url.split("/");
        StringBuilder encodedUrl = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (i == 0) {
                // 保留协议头（http://）
                encodedUrl.append(part);
            } else if (i == parts.length - 1) {
                // 编码文件名部分
                String encodedFileName = encodeFileName(part);
                encodedUrl.append("/").append(encodedFileName);
            } else {
                // 编码路径部分
                String encodedPath = encodePathSegment(part);
                encodedUrl.append("/").append(encodedPath);
            }
        }

        return encodedUrl.toString();
    }

    private static String encodePathSegment(String segment) throws UnsupportedEncodingException {
        return URLEncoder.encode(segment, StandardCharsets.UTF_8.name())
                .replace("+", "%20")
                .replace("%2F", "/") // 保留路径分隔符
                .replace("%3A", ":"); //保留冒号
    }

    private static String encodeFileName(String fileName) throws UnsupportedEncodingException {
        // 分离文件名和扩展名
        String[] nameAndExt = fileName.split("\\.", 2);
        String encodedName = URLEncoder.encode(nameAndExt[0], StandardCharsets.UTF_8.name())
                .replace("+", "%20");

        if (nameAndExt.length > 1) {
            return encodedName + "." + nameAndExt[1];
        }
        return encodedName;
    }

}
