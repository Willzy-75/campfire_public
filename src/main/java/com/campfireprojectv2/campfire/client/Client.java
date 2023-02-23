package com.campfireprojectv2.campfire.client;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private List<UserStory> userStories;

    public Client() {
        userStories = new ArrayList<>();
    }

    public void addUserStory(UserStory userStory) {
        userStories.add(userStory);
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public static class UserStory {
        private int id;
        private String name;
        private String persona;
        private String whatToDo;
        private String whyToDo;
        private boolean editable;
        private int complexity;

        public UserStory(int id, String name, String persona, String whatToDo, String whyToDo, boolean editable, int complexity) {
            this.id = id;
            this.name = name;
            this.persona = persona;
            this.whatToDo = whatToDo;
            this.whyToDo = whyToDo;
            this.editable = editable;
            this.complexity = complexity;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPersona() {
            return persona;
        }

        public String getWhatToDo() {
            return whatToDo;
        }

        public String getWhyToDo() {
            return whyToDo;
        }

        public boolean isEditable() {
            return editable;
        }

        public int getComplexity() {
            return complexity;
        }
    }
}

