package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElement;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElement, Deque<Character> evenElements) {
        this.descendingElement = descendingElement;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        String element;
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            element = String.valueOf(evenElements.pollFirst());
            if (i % 2 == 0) {
                result.append(element);
            }
        }
        return String.valueOf(result);
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        Iterator<Character> iterator = descendingElement.descendingIterator();
        while (iterator.hasNext()) {
           result.append(iterator.next());
        }
        return String.valueOf(result);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
