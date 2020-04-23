package com.example.infs3605_group_project.activities;

public class PersonalityApiReponse
{

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

    public Definitions getDefinitions() {
        return definitions;
    }

    private Definitions definitions;


    public class Definitions
    {

        private QuestionnaireDataResult questionnaireDataResult;

        public QuestionnaireDataResult getQuestionnaireDataResult() {
            return questionnaireDataResult;
        }

        public class QuestionnaireDataResult
        {
            public Properties getProperties() {
                return properties;
            }

            private Properties properties;

            public class Properties
            {
                public Questions getQuestions() {
                    return questions;
                }

                private Questions questions;

                public class Questions
                {   //Questions Attributes
                    public Example[] example;
                    //Getter
                    public Example[] getExample()
                    { return example;}
                    //Example Class
                    public class Example
                    { //Example Attributes
                        private int questionId;
                        private String questionText;
                        public Responses[] responses;
                        //Getter for Example Attributes
                        public int getQuestionId()
                        { return questionId; }
                        public String getQuestionText()
                        { return questionText; }
                        public Responses[] getResponses()
                        { return responses; }
                        public class Responses
                        { private String responseText;}
                    }
                }

            }
        }
    }
}
