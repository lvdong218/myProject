package com.ld.filter.until;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class ExpertPdfUtils {
	public void exportPdf(Object obj, HttpServletResponse response) throws Exception {
		response.reset();
        response.setContentType("application/pdf;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=\""
                + new String(("name"+".pdf").getBytes("GBK"),
                        "ISO8859_1") + "\"");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer=PdfWriter.getInstance(doc, baos);
		ByteArrayInputStream bin = new ByteArrayInputStream( obj==null?"".getBytes("UTF-8"):obj.toString().getBytes("UTF-8"));
		//设置全局字体，解决中文问题。
		BaseFont baseFont = BaseFont.createFont("simkai.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED); 
		Font  fontContent= new Font(baseFont); 
		PdfReportM1HeaderFooter event = new PdfReportM1HeaderFooter();    
		writer.setPageEvent(event);
		//打开文档
		doc.open();
		Font font =new Font(baseFont);
		//主标题
		font.setSize(20);
		font.setStyle(Font.BOLD);
		Paragraph titlePara=new Paragraph("",font);
		titlePara.setAlignment(1);
		doc.add(titlePara);
		font.setSize(14);
		fontContent.setColor(new BaseColor(169,169,169));
		//首行缩进字符16f约为一个字符
		//titlePara.setFirstLineIndent(14);
		//将doc中的标签进行转换为pdf样式展示
		XMLWorkerHelper.getInstance().parseXHtml(writer, doc, bin, Charset.forName("UTF-8"), new ChinaFontProvide());
		doc.close();
		addWartmark(baos);
		baos.writeTo(response.getOutputStream());
		baos.close();
	}
	/**
	 * 给导出pdf输出字节流上增加水印
	 * @param baos
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public void addWartmark(ByteArrayOutputStream baos) {
		byte[] bytes=baos.toByteArray();
		BaseFont baseFont;
		PdfStamper stamper=null;
		//将bytes放到字节输入流中
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		try {
			baseFont = BaseFont.createFont("simkai.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			//使用PdfReader读取字节输入流
			PdfReader reader=new PdfReader(bais);
			
			stamper= new PdfStamper(reader, baos);
			//获取总页数起始0
			int total=reader.getNumberOfPages()+1;
			//水印设置样式使用类
			PdfContentByte pdfContent;
			
			PdfGState gs = new PdfGState();
			for(int i=1;i<total;i++) {
				pdfContent=stamper.getUnderContent(i);
				//设置透明度
				gs.setFillOpacity(0.3f);
				//开始设置文本内容
				pdfContent.beginText();
				//设置文字字体
				pdfContent.setColorFill(BaseColor.LIGHT_GRAY);
				pdfContent.setFontAndSize(baseFont, 50);
				//字体位置
				pdfContent.setTextMatrix(70, 200);
				//倾斜度
				pdfContent.setTextRise(5f);
				//横向居中
//				pdfContent.setTextMatrix((pageWidth-fontSize*stampStr.length())/2+50,(pageHeight-fontSize*stampStr.length())/2+100);
//				pdfContent.showTextAligned(Element.ALIGN_CENTER, "此处为水印", 300,350, 55);
				pdfContent.newlineShowText("此处为水印");
				pdfContent.endText();
			}
			stamper.close();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
}
