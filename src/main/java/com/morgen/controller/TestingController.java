package com.morgen.controller;

import com.morgen.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@RequestMapping("/testing")
@Controller
public class TestingController {

    private final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    //private final TestingService testingService;

//    @Inject
//    public TestingController(TestingService testingService) {
//        this.testingService = testingService;
//    }

    @RequestMapping(value = "/starttesting", method = RequestMethod.GET)
    public String startTesting(Model model) {
        model.addAttribute("question", new Question());
        return "addquestion";
    }

    @RequestMapping(value = "/starttesting", method = RequestMethod.POST)
    public String startTesting(@ModelAttribute Question question, Model model) {
//        questionService.addQuestion(question);
        model.addAttribute("question", question);
        return "result";
    }

    @RequestMapping(value = "/sorted")
    public String findQuestion(Model model) {

        int result = 0;
        LOGGER.info("First argument: {}, second argument {}, action - add,result: {},result");
        // sorted();


        List<RegistersDTO> sorted = sorted();
        sorted.forEach(dto -> LOGGER.info("SortedList date {}", dto.getCtreateTranchDate()));

        model.addAttribute("sum", result);
        return "sorted";
    }

    private HashMap<RegistersDTO, EnumMap<RegisterType, Integer>> createEnumMapTypePriority() {

        return new HashMap<RegistersDTO, EnumMap<RegisterType, Integer>>();
    }

    private List<RegistersDTO> sorted() {
        List<RegistersDTO> registersDTOList = createRegistersDTOList();

        registersDTOList.sort((RegistersDTO register1, RegistersDTO register2) -> {

            int first = register1.getCtreateTranchDate().compareTo(register2.ctreateTranchDate);
            return first;
        });


        return registersDTOList;
    }

    Map<RegistersDTO, EnumMap<RegisterName, Integer>> createData() {
        Map<RegistersDTO, EnumMap<RegisterName, Integer>> registersDTOEnumMapMap = new HashMap<>();
        Map<RegisterName, Integer> registerNameIntegerMapDEBIT = new HashMap<>();
        Map<RegisterName, Integer> registerNameIntegerMapDUO = new HashMap<>();
        Map<RegisterName, Integer> registerNameIntegerMapLOAN = new HashMap<>();

//        registersDTOEnumMapMap.put(new RegistersDTO(RegisterName.DEBIT, RegisterType.CASH, new Date("10.02.2018")),
//                new EnumMap<RegisterName, Integer>(registerNameIntegerMapDEBIT));
//        registersDTOEnumMapMap.put(new RegistersDTO(RegisterName.DUO, RegisterType.CASH, new Date("10.02.2018")),
//                new EnumMap<RegisterName, Integer>(registerNameIntegerMapDUO));
//        registersDTOEnumMapMap.put(new RegistersDTO(RegisterName.LOAN, RegisterType.CASH, new Date("10.02.2018")),
//                new EnumMap<RegisterName, Integer>(registerNameIntegerMapLOAN));
        return registersDTOEnumMapMap;


    }

    List<RegistersDTO> createRegistersDTOList() {
        List<RegistersDTO> registersDTOList = new ArrayList<>();
        registersDTOList.add(new RegistersDTO(RegisterName.DEBIT, RegisterType.CASH, 13));
        registersDTOList.add(new RegistersDTO(RegisterName.LOAN, RegisterType.SALE, 10));
        registersDTOList.add(new RegistersDTO(RegisterName.DUO, RegisterType.CASH, 17));
        return registersDTOList;
    }
}


enum RegisterName {
    DUO,
    LOAN,
    DEBIT
}

class RegistersDTO {
    RegisterName name;
    RegisterType type;
    Integer ctreateTranchDate;

    public RegistersDTO(RegisterName name, RegisterType type, Integer ctreateTranchDate) {
        this.name = name;
        this.type = type;
        this.ctreateTranchDate = ctreateTranchDate;
    }

    public RegisterName getName() {
        return name;
    }

    public void setName(RegisterName name) {
        this.name = name;
    }

    public RegisterType getType() {
        return type;
    }

    public void setType(RegisterType type) {
        this.type = type;
    }

    public Integer getCtreateTranchDate() {
        return ctreateTranchDate;
    }

    public void setCtreateTranchDate(Integer ctreateTranchDate) {
        this.ctreateTranchDate = ctreateTranchDate;
    }
}

enum RegisterType {
    CASH,
    SALE,
    NINE;

}