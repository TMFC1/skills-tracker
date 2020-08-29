package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
public class SkillsTrackerController {
    List<String> languages = Arrays.asList("6502 Assembler", "ARM7TDMI", "C", "C++", "C#", "Chip8", "Haxe", "Java", "JavaScript", "Python", "Z80");

    @GetMapping("/")
    public String postMyFavoredLanguages() {
        int[] myChoices = {1, 6, 9};
        String header1 = "Skills Tracker";
        String header2 = "Best stuff right here";
        StringBuilder completeText = new StringBuilder();
        completeText.append("<h1>" +header1+ "</h1>" +"<h2>" +header2+ "<h2><ol>");
        for  (int choice : myChoices){
            completeText.append("<li>" + languages.get(choice) + "</li>");
        }
        completeText.append("</ol>");
        return completeText.toString() + "<a href = '/form'>Go to form</a>";
    }



    @GetMapping("/form")
    public String createAForm() {
        StringBuilder optionList = new StringBuilder();
        for (String language : languages) {
            optionList.append("<option value = '" +language+ "'>" +language+ "</option>" );
        }
        optionList.append("</select>");
        return "<form action='/form/results' method='post'>" +
                "<label for='userName'>Name:</label>" +
                "<input type='text' name = 'userName'><br>" +
                "<label for='selectionOne'>Favored Language: </label>" +
                "<select name = 'selectionOne'>" +
                optionList.toString() + "<br>" +
                "<label for='selectionTwo'>Second Favored Language: </label>" +
                "<select name = 'selectionTwo'>" +
                optionList.toString() + "<br>" +
                "<label for='selectionThree'>Third Favored Language: </label>" +
                "<select name = 'selectionThree'>" +
                optionList.toString() + "<br>" +
                "<input type='submit' value='submit your choices'>";
    }

    @PostMapping("/form/results")
    public String postChoices(@RequestParam String userName, String selectionOne, String selectionTwo, String selectionThree) {
        return "<h1>"  + userName       + "<h1>" +
                "<table>" +
                "<tr>" +
                "<th>Favored Language</th> " +
                "<th>Second Favored Language</th>" +
                "<th>Third Favored Language</th>" +
                "</tr>" +
                "<tr>"  +
                "<td>"  +selectionOne+   "</td>" +
                "<td>"  +selectionTwo+   "</td>" +
                "<td>"  +selectionThree+ "</td>" +
                "</tr>" +
                "</table>";
//               "<ol>"  +
//               "<li>"  + selectionOne   + "</li>" +
//               "<li>"  + selectionTwo   + "</li>" +
//               "<li>"  + selectionThree + "</li>" +
//               "</ol>";
    }
}
