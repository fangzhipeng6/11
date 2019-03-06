package org.crazyit.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.demo.DemoApp;
import org.crazyit.demo.WebMvcConfig;
import org.crazyit.demo.entity.User;
import org.crazyit.demo.service.UserService;
import org.crazyit.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model,
            @PageableDefault(size = DemoApp.PAGE_SIZE) Pageable pageable) {
        model.addAttribute("datas", userService.findAll(pageable));
        return "user/list";
    }

    /**
     * 打开添加页面
     * 
     * @return
     */
    @GetMapping("/add")
    public String add(@ModelAttribute User user) {
        return "user/content";
    }

    /**
     * 打开修改界面
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable Integer userId, @ModelAttribute User user,
            Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "user/content";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute User user) throws IOException {
        userService.save(user);
        return "redirect:/user/list";
    }

    /**
     * 打开查看界面
     */
    @GetMapping("/view/{userId}")
    public String view(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("readonly", true);
        return "user/content";
    }

    @RequestMapping("/delete/{page}")
    public String delete(@RequestParam Integer[] ids, @PathVariable Integer page) {
        userService.delete(ids);
        return "redirect:/user/list?page=" + page;
    }

    @RequestMapping("/upload")
    public void upload(@RequestParam("cover") MultipartFile uploadFile,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        byte[] content = uploadFile.getBytes();
        // 保存文件到具体目录，此处为D:/book/upload
        String path = WebMvcConfig.FILE_DIR;
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // 获取文件后缀
        String fileSuffix = FileUtil
                .getSuffix(uploadFile.getOriginalFilename());
        // 设置文件名
        File file = new File(folder.getAbsolutePath() + File.separator
                + UUID.randomUUID().toString() + fileSuffix);
        file.createNewFile();
        // 写到服务器文件
        FileUtil.writeFile(file, content);
        response.getWriter().write("/upload/" + file.getName());
    }

    /**
     * 打开选择书本界面
     * 
     * @return
     */
    @GetMapping("/choose")
    public String choose(Model model,
            @PageableDefault(size = DemoApp.PAGE_SIZE) Pageable pageable) {
        model.addAttribute("datas", userService.findAll(pageable));
        return "user/choose";
    }
    
    @GetMapping("/test")
    public String testFindAll(Model model, Pageable pageable) {
        model.addAttribute("datas", userService.testFindAll(pageable));
        return "user/test";
    }
}
