package pl.spaszek.ds.application.controller;

import org.springframework.web.servlet.ModelAndView;

public interface ApplicationController {

    ModelAndView doGetInitialView();
    ModelAndView doGetAdminView();
    ModelAndView doGetCourierView();


}
