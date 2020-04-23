package com.example.infs3605_group_project.activities;

import java.util.ArrayList;

public class QuestionnaireDataResult {
    private String type;

    public APIProperties getProperties() {
        return properties;
    }

    private APIProperties properties;

    public String getType() {
        return type;
    }

    public class APIProperties{

        public Questions getQuestions() {
            return questions;
        }

        private Questions questions;

        public class Questions{
            public ArrayList<Example> getExample() {
                return example;
            }

            private ArrayList<Example> example;


            public class Example{
                public String getQuestionId() {
                    return questionId;
                }

                public String getQuestionText() {
                    return questionText;
                }


                public ArrayList<Responses> getResponses() {
                    return responses;
                }

                private ArrayList<Responses> responses;
                private String questionId;
                private String questionText;

                public class Responses {

                    public String getResponseText()
                    {
                        return responseText;
                    }

                    private String responseText;

                }

            }

        }





    }
}
