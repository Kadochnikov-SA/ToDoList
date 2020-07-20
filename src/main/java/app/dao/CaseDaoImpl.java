package app.dao;

import app.model.Case;
import app.model.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This public class CaseDaoImpl process requests from {@code CaseController}
 * and interacts with data base
 *
 * @author Kadochnikov Sregey
 */
@Service("caseDao")
public class CaseDaoImpl implements CaseDao {

    @Autowired
    private CaseRepository caseRepository;


    @Override
    public List<Case> getAll() {
        List<Case> caseList = new ArrayList<>();
        Iterable<Case> caseIterable = caseRepository.findAll();
        for (Case c : caseIterable) {
            caseList.add(c);
        }
        return caseList;
    }

    @Override
    public Case getOne(int id) {
        Case c = caseRepository.findById(id).orElseThrow();
        return c;
    }


    @Override
    public void addCase(String name, String time, String description) {
        Case caseToAdd = new Case(name, description, repairDate(time));
        caseRepository.save(checkFields(caseToAdd));
    }

    @Override
    public void updateCase(int id, String name, String time, String description) {
        Case newCase = new Case(name, description, repairDate(time));
        caseRepository.deleteById(id);
        caseRepository.save(checkFields(newCase));
    }

    @Override
    public void deleteCase(int id) {
        caseRepository.deleteById(id);
    }

    private Case checkFields(Case newCase) {
        if (newCase.getName().equals("")) {
            newCase.setName("unspecified");
        }
        if (newCase.getDescription().equals("")) {
            newCase.setDescription("unspecified");
        }
        if (newCase.getTime().equals("")) {
            newCase.setTime("unspecified");
        }
        return newCase;
    }

    private String repairDate(String time) {
        String t = time.replaceAll("[-]", ".");
        String t2 = t.replaceAll("[T]", " ");
        return t2;
    }

}
