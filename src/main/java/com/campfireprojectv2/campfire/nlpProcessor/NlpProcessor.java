package com.campfireprojectv2.campfire.nlpProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import edu.stanford.nlp.ling.CoreAnnotations;
//import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.pipeline.Annotation;
//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
//import edu.stanford.nlp.semgraph.SemanticGraph;
//import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
//import edu.stanford.nlp.semgraph.SemanticGraphEdge;
//import edu.stanford.nlp.util.CoreMap;

public class NlpProcessor {

//    private StanfordCoreNLP pipeline;
//
//    public NlpProcessor() {
//        Properties props = new Properties();
//        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
//        pipeline = new StanfordCoreNLP(props);
//    }
//
//    public List<String> extractNounPhrases(String text) {
//        List<String> nounPhrases = new ArrayList<>();
//        Annotation document = new Annotation(text);
//        pipeline.annotate(document);
//        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
//        for (CoreMap sentence : sentences) {
//            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation.class);
//            for (SemanticGraphEdge edge : dependencies.edgeListSorted()) {
//                if (edge.getRelation().toString().equals("nn") && edge.getSource().tag().startsWith("N")) {
//                    String nounPhrase = edge.getSource().word();
//                    for (CoreLabel token : edge.getSource().backingLabel().get(CoreAnnotations.TokensAnnotation.class)) {
//                        nounPhrase += " " + token.word();
//                    }
//                    nounPhrases.add(nounPhrase);
//                }
//            }
//        }
//        return nounPhrases;
//    }
//
//    public List<String> extractVerbPhrases(String text) {
//        List<String> verbPhrases = new ArrayList<>();
//        Annotation document = new Annotation(text);
//        pipeline.annotate(document);
//        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
//        for (CoreMap sentence : sentences) {
//            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation.class);
//            for (SemanticGraphEdge edge : dependencies.edgeListSorted()) {
//                if (edge.getRelation().toString().startsWith("nsubj") && edge.getTarget().tag().startsWith("V")) {
//                    String verbPhrase = edge.getTarget().word();
//                    for (CoreLabel token : edge.getTarget().backingLabel().get(CoreAnnotations.TokensAnnotation.class)) {
//                        verbPhrase += " " + token.word();
//                    }
//                    verbPhrases.add(verbPhrase);
//                }
//            }
//        }
//        return verbPhrases;
//    }

}