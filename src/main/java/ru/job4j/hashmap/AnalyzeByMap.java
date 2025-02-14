package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        List<Subject> subjects = new ArrayList<>();
        int result = 0;
        int count = 0;

        for (Pupil p : pupils) {
            subjects.addAll(p.subjects());
        }

        for (Subject s : subjects) {
            result += s.score();
            count++;
        }

        return (double) result / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();

        int result = 0;

        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                result += s.score();
            }
            labels.add(new Label(p.name(), (double) result / p.subjects().size()));
            result = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil p : pupils) {
             for (Subject s : p.subjects()) {
                 map.merge(s.name(), (double) s.score(), Double::sum);
             }
        }

        for (String name : map.keySet()) {
            labels.add(new Label(name, map.get(name) / pupils.size()));
        }

        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        int result = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                result += s.score();
            }
            labels.add(new Label(p.name(), result));
            result = 0;
        }

        labels.sort(Comparable::compareTo);

        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                map.merge(s.name(), s.score(), Integer::sum);
            }
        }

        for (String name : map.keySet()) {
            labels.add(new Label(name, map.get(name)));
        }

        labels.sort(Comparable::compareTo);
        return labels.get(labels.size() - 1);
    }
}
