package app.controllers;

import app.dao.CaseDao;
import app.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This public class CaseController is a controller for the case entity.
 * Class process put and get requests and generates view models.
 *
 * @author Kadochnikov Sregey
 */
@Controller
public class CaseController {

    @Autowired
    private CaseDao caseDao;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cases", caseDao.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String addCase(Model model) {
        return "addcase";
    }

    @GetMapping("{id}/update/")
    public String updateCase(@PathVariable int id, Model model) {
        Case c = caseDao.getOne(id);
        model.addAttribute("name", c.getName());
        model.addAttribute("description", c.getDescription());
        model.addAttribute("time", c.getTime());
        return "updatecase";
    }

    @PostMapping("/add")
    public String addCase(@RequestParam String name, @RequestParam String time,
                          @RequestParam String description, Model model) {
        caseDao.addCase(name, time, description);
        return "redirect:/";
    }


    @PostMapping("{id}/update")
    public String updateCase(@PathVariable int id, @RequestParam String name,
                             @RequestParam String time, @RequestParam String description, Model model) {
        caseDao.updateCase(id, name, time, description);
        return "redirect:/";
    }


    @PostMapping("{id}/remove")
    public String deleteCase(@PathVariable int id, Model model) {
        caseDao.deleteCase(id);
        return "redirect:/";
    }
}
