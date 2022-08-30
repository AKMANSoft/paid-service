package com.example.modulepaidservice.modulepaid.controller.pri;

import com.example.modulepaidservice.modulepaid.dto.ModulePaidSearchReq;
import com.example.modulepaidservice.modulepaid.dto.ModulePaidUpdateReq;
import com.example.modulepaidservice.modulepaid.response.ModulePaidRes;
import com.example.modulepaidservice.modulepaid.service.ModulePaidService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/module-paid")
@RequiredArgsConstructor
public class ModulePaidSearchController {

    private final ModulePaidService modulePaidService;

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false, name = "orderNo") String orderNo,
                               @RequestParam(required = false, name = "clientTin") String clientTin,
                               @RequestParam(required = false, name = "deviceNo") String deviceNo,
                               @RequestParam(required = false, name = "link") String link,
                               @RequestParam(required = false, name = "status") String status,
                               @RequestParam(required = false, name = "date") String date,
                               @RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue = "20") Integer size,
                               @RequestParam(defaultValue = "createdDate") String sort,
                               @RequestParam(defaultValue = "desc") String sortDir) {
        var req = ModulePaidSearchReq.builder()
                .orderNo(!StringUtils.isBlank(orderNo) ? orderNo : null)
                .clientTin(!StringUtils.isBlank(clientTin) ? clientTin : null)
                .deviceNo(!StringUtils.isBlank(deviceNo) ? deviceNo : null)
                .link(!StringUtils.isBlank(link) ? link : null)
                .status(!StringUtils.isBlank(status) ? status : null)
                .date(!StringUtils.isBlank(date) ? date : null)
                .build();

        ModelAndView modelAndView = new ModelAndView("paid");
        modelAndView.addObject("modulePaid", modulePaidService.search(req, page, size, sort, sortDir));
        modelAndView.addObject("page", page);
        modelAndView.addObject("size", size);
        modelAndView.addObject("sort", sort);
        modelAndView.addObject("sortDir", sortDir);
        modelAndView.addObject("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        modelAndView.addObject("orderNo", orderNo);
        modelAndView.addObject("clientTin", clientTin);
        modelAndView.addObject("deviceNo", deviceNo);
        modelAndView.addObject("link", link);
        modelAndView.addObject("status", status);
        modelAndView.addObject("date", date);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView update(ModulePaidUpdateReq req) {
        modulePaidService.update(req);
        return new ModelAndView(String.format("redirect:%s", "/module-paid/search"));
    }

    @GetMapping("/edit")
    @ResponseBody
    public ModulePaidRes update(Long id) {
        return modulePaidService.get(id);
    }
}
