package com.controller;



import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.util.ExcelRead;


@Controller
@RequestMapping("excel")
public class ExcelController {
	
	
	@RequestMapping("tongbu")
	public String tongbu(@RequestParam(value = "tofile", required = false) MultipartFile tofile,@RequestParam(value = "fromfile", required = false) MultipartFile fromfile,HttpServletRequest request,HttpServletResponse response, ModelMap modelmap) throws Exception{	
		HttpSession session=request.getSession();
		String file=request.getParameter("tofile");
		
		String filePath = tofile.getOriginalFilename();
		
		
		filePath=URLEncoder.encode(filePath, "UTF-8");  
		
		if(fromfile.isEmpty()) {
			 session.setAttribute("msg", 1);
		     return "redirect:../index.jsp";	
		}
		List<ArrayList<String>> fromlist=ExcelRead.readExcel(fromfile);
		
		for(int f=1;f<fromlist.size();f++) {
			for(int in=fromlist.get(f).size();in<fromlist.get(0).size();in++) {
				fromlist.get(f).add("");
			}
		}
		List<ArrayList<String>> tolist=ExcelRead.readExcel(tofile);
		
	
		int toNum=tolist.size();
		int[] from = new int[100];
		int[] to = new int[100];
		int n=0;
		for(int i=0;i<fromlist.get(0).size();i++) {
			for(int j=0;j<tolist.get(0).size();j++) {
				if(tolist.get(0).get(j).equals(fromlist.get(0).get(i))) {
					from[n]=i;
					to[n]=j;
					n++;
				}
			}
		}
		InputStream input = tofile.getInputStream();
		HSSFWorkbook wb = new HSSFWorkbook(input); 
		HSSFSheet sheet = wb.getSheetAt(0);
		
		for(int k=1;k<fromlist.size();k++) {
			HSSFRow row=sheet.createRow(toNum);
			
			for(int l=0;l<n;l++) {
			   row.createCell(to[l]).setCellValue(fromlist.get(k).get(from[l]));
			  
		    }
			toNum++;
			
		}
		/*// 首先要创建一个原始Excel文件的输出流对象！

		FileOutputStream excelFileOutPutStream = new FileOutputStream("D:/aaa/工资导入表4月(1).xls");

		// 将最新的 Excel 文件写入到文件输出流中，更新文件信息！

		wb.write(excelFileOutPutStream);

		 // 执行 flush 操作， 将缓存区内的信息更新到文件上

		excelFileOutPutStream.flush();
        
		// 使用后，及时关闭这个输出流对象， 好习惯，再强调一遍！

		excelFileOutPutStream.close();*/
		
		
		OutputStream output=response.getOutputStream();
		response.reset();
	    response.setHeader("Content-disposition", "attachment; filename="+filePath);
	    response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
		
		session.setAttribute("msg", 2);
		return "index";	
	}
}
