package com.example.infs3605_group_project.activities;

import java.util.ArrayList;
import java.util.Properties;

public class PersonalityApiReponse
{
    //Attribute
    private Info info;

    private Definitions definitions;
    //Getter
    public Info getInfo() {
        return info;
    }
    public Definitions getDefinitions() {
        return definitions;
    }

    //Info Class
    public class Info
    {
        // Quiz Description
        private String description;
        // Quiz Getter
        public String getDescription()
        {
            return description;
        }
    }


}
