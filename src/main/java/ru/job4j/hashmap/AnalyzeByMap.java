package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            score /= pupil.subjects().size();
            averageScore.add(new Label(pupil.name(), score));
        }
        return averageScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjects = new LinkedHashMap<>();
        List<Label> averageScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjects.put(subject.name(), subjects.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String subject : subjects.keySet()) {
            int score = subjects.get(subject) / pupils.size();
            averageScore.add(new Label(subject, score));
        }
        return averageScore;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> bestScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            bestScore.add(new Label(pupil.name(), score));
        }
        bestScore.sort(Comparator.naturalOrder());
        return bestScore.get(bestScore.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjects = new LinkedHashMap<>();
        List<Label> bestScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjects.get(subject.name()) == null) {
                    subjects.put(subject.name(), subject.score());
                } else {
                    subjects.put(subject.name(), subjects.get(subject.name()) + subject.score());
                }
            }
        }
        for (String subject : subjects.keySet()) {
            bestScore.add(new Label(subject, subjects.get(subject)));
        }
        bestScore.sort(Comparator.naturalOrder());
        return bestScore.get(bestScore.size() - 1);
    }
}
