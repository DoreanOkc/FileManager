package net.univer.filemanager.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.univer.filemanager.domain.File;
import net.univer.filemanager.service.FileService;
import net.univer.filemanager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileController {

	@Autowired
	private FileService fileService;
	@Autowired
	private UserService userService;

	@RequestMapping("/userfile")
	public String userListFile(Map<String, Object> map) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		int userid = userService.getUser(username).getId();
		
		map.put("userfile", new File());
		map.put("userFileList", fileService.listFile(userid));

		return "userfile";
	}
	
	@RequestMapping("/files")
	public String listFile(Map<String, Object> map) {
		map.put("shareFileList", fileService.shareFileList());
		map.put("fileList", fileService.listFile());
		return "files";
	}
	
	@RequestMapping("/cancel")
	public String cancel() {
		return "redirect:/userfile";
	}
	
	
	@RequestMapping(value = "/addfile", method = RequestMethod.POST)
	public String addFile(@RequestParam("description") String description,
			@RequestParam(required=false, value="shared") boolean shared,
	        @RequestParam("file") MultipartFile fileUpload) throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		int userid = userService.getUser(username).getId();
		
		System.out.println(shared);
		
        File file = new File();
        file.setFilename(fileUpload.getOriginalFilename());
        file.setUserid(userid);
        file.setDescription(description);
        file.setFile(fileUpload.getBytes());
        file.setType(fileUpload.getContentType());
        file.setShared(shared);
		
		fileService.addFile(file);

		return "redirect:/userfile";
	}

	@RequestMapping("/editfile/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		File file = fileService.getFile(id);
		model.addAttribute("fileId", id);
		model.addAttribute("filename", file.getFilename());
		model.addAttribute("shared", file.isShared());
		model.addAttribute("description", file.getDescription());
        return "editfile";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editFile(@ModelAttribute("id") Integer fileId, BindingResult result,
			@RequestParam("description") String description,
			@RequestParam(required=false, value="shared") boolean shared,
			@RequestParam("filename") String filename) {
		System.out.println(filename + description);
		File file = fileService.getFile(fileId);
		file.setFilename(filename);
		file.setShared(shared);
		file.setDescription(description);
		return "redirect:/userfile";
	}
	
	@RequestMapping("/delete/{fileId}")
	public String deleteFile(@PathVariable("fileId") Integer fileId) {

		fileService.removeFile(fileId);

		return "redirect:/userfile";
	}
	
	@RequestMapping("/download/{fileId}")
	public void downloadFile(@PathVariable("fileId") Integer fileId, HttpServletResponse response) throws IOException {
		File file = fileService.getFile(fileId);
		byte[] bytes = file.getFile();
		
		response.setContentType(file.getType());
        response.setContentLength(new Long(bytes.length).intValue());
        response.setHeader("Content-Disposition","attachment; filename=" + fileService.getFile(fileId).getFilename());
 
        OutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
        out.close();
	}
	
			
}
