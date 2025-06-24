package com.ruoyi.common.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;

/**
 * 包名：com.ruoyi.common.utils
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-06-11 22:44
 **/
public class PdfUtils {

    public static String getPdfContent(InputStream inputStream) throws IOException {
        PDDocument document = PDDocument.load(inputStream);
        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(document);
    }

}
