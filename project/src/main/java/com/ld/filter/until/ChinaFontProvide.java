package com.ld.filter.until;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.pdf.BaseFont;

/**
 * 
 * FontProvider实现类用于XMLWorkerHelper的parseXHtml转换方法解决中文乱码问题
 * @author lvdong
 */
public class ChinaFontProvide implements FontProvider {
	
	@Override
	public Font getFont(String arg0, String arg1, boolean arg2, float arg3,
			int arg4, BaseColor arg5) {
		BaseFont bfChinese = null;
		try {
			bfChinese =  BaseFont.createFont("simkai.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
		return FontChinese;
	}

	@Override
	public boolean isRegistered(String arg0) {
		return false;
	}
}
