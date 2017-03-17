package cn.xuxianda.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.xuxianda.entity.Account;
import cn.xuxianda.service.AccountService;

@Controller
@RequestMapping("/file")
public class FileAction {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/getHeadImage")
	/*@RequiresPermissions("asdfas")*/
	public void getHeadImage(HttpServletRequest request,HttpServletResponse response){
		InputStream in = null;
		OutputStream os = null;
		try{
			Account account = (Account)request.getSession().getAttribute("account");
			String rootPath =  request.getSession().getServletContext().getRealPath("");
			String imagePath = rootPath+"\\WEB-INF\\images\\user.jpg";
			if(account.getHeadImage()!=null&&!"".equals(account.getHeadImage())){
				imagePath = account.getHeadImage();
			}
			in = new FileInputStream(imagePath);
			byte[] buffer = new byte[1024*8];
			int length = 0;
			os = response.getOutputStream();
			while((length = in.read(buffer))!=-1){
				os.write(buffer,0,length);
				os.flush();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
				os.close();
			}catch(Exception e){
				
			}
		}
	}
	
	@RequestMapping("/upLoadFile")
	public void upLoadFile(@RequestParam(value="file",required=false) MultipartFile file,HttpSession session) throws Exception{
		try{
			Account account = (Account)session.getAttribute("account");
			String rootPath = "D:/images";
			if(!file.isEmpty()){
				//获取文件类型(判断如果不是图片类型禁止上传)
				String contentType = file.getContentType();
				List<String> fileTypes = new ArrayList<String>();
				fileTypes.add("image/png");
				fileTypes.add("image/jpeg");
				fileTypes.add("image/gif");
				if(fileTypes.contains(contentType)){
					String fileName = file.getOriginalFilename();//获取图片的名称
					String suffix = fileName.substring(fileName.indexOf(".")+1);//获取图片的后缀
					String datePath = new SimpleDateFormat("yyyyMMddhh").format(new Date());
					String UUIDPath = UUID.randomUUID().toString().replace("-", "");
					String upLoadFilePath = rootPath + "/" + datePath + "/"+UUIDPath+"."+suffix;//存储在数据库中的图片名称
					File image = new File(upLoadFilePath);
					image.mkdirs();
					file.transferTo(image);
					account.setHeadImage(upLoadFilePath);
					accountService.updateSelectParams(account);
				}
			}
		}catch(Exception e){
			
		}
	}
	
}
