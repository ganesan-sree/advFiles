package com.spring.annotation;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class FilesUploadController {
	private static final String UPLOAD_DIRECTORY = "/home/ganesh/f/";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp))$)";
	private static final String FILE_PATTERN = "([^\\s]+(\\.(?i)(jpg|jpeg|png|flv|mpg|mpeg|mp4|avi|vob|mkv))$)";

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {

		File dir = new File(UPLOAD_DIRECTORY);
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
			for (String aFile : files) {
				System.out.println(aFile);
			}
		}

		model.put("fileList", files);

		return "uploadform";
	}

	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file,
			HttpSession session) throws Exception {

		if (!isFileNameValid(file.getOriginalFilename())) {
			return new ModelAndView("redirect:/f/upload", "vf", "true");
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// ServletFileUpload upload = new ServletFileUpload(factory);
		// ServletContext context = session.getServletContext();
		//
		// String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
		// System.out.println(uploadPath);

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(UPLOAD_DIRECTORY + File.separator
						+ file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();

		if (isImage(file.getOriginalFilename())) {
			convertImg2Video(UPLOAD_DIRECTORY + file.getOriginalFilename());
			deteleFile(file.getOriginalFilename());
		}
		return new ModelAndView("redirect:/f/upload", "fu", "true");
	}

	@RequestMapping(value = "deletefile", method = RequestMethod.POST)
	public ModelAndView deletimage(@RequestParam String filename,
			HttpSession session) throws Exception {

		System.out.println("GGGGGGGGGGGG\n\n" + filename);

		deteleFile(filename);

		return new ModelAndView("redirect:/f/upload", "fd", "true");
	}

	void convertImg2Video(String fileName) throws IOException,
			InterruptedException {

		String command = String
				.format("ffmpeg -loop 1 -i %s -c:v libx264 -t %d -pix_fmt yuv420p -vf scale=1920:1080 %s",
						fileName, 20, formatFileName(fileName));

		System.out.println(command);

		Process pr = Runtime.getRuntime().exec(command);
		pr.waitFor();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}

	}

	private String formatFileName(String fileName) {

		String REGEX = "\\..*$";
		String REPLACE = ".mp4";
		Pattern p = Pattern.compile(REGEX);
		// get a matcher object
		Matcher m = p.matcher(fileName);
		fileName = m.replaceAll(REPLACE);
		System.out.println(fileName);
		return fileName;

	}

	private void deteleFile(String filename) {

		File file = new File(UPLOAD_DIRECTORY + filename);
		if (file.exists()) {
			boolean status = file.delete();
			System.out.println(file.getName() + " is deleted! status = "
					+ status);
		} else {
			System.out.println("Delete operation is failed.");
		}

	}

	private boolean isImage(String filename) {
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);
		Matcher matcher = pattern.matcher(filename);
		return matcher.matches();
	}

	private boolean isFileNameValid(String filename) {
		Pattern pattern = Pattern.compile(FILE_PATTERN);
		Matcher matcher = pattern.matcher(filename);
		return matcher.matches();
	}
}
