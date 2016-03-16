package pl.spaszek.ds.infrastracture.controller;

import org.springframework.web.servlet.ModelAndView;

public interface ApplicationController {

    ModelAndView doGetInitialView();
    ModelAndView doGetAdminView();
    ModelAndView doGetCourierView();


}
