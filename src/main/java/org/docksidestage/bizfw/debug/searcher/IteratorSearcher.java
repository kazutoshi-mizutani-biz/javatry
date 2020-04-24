package org.docksidestage.bizfw.debug.searcher;

import java.util.Iterator;
import java.util.List;

import org.docksidestage.bizfw.debug.Word;
import org.docksidestage.bizfw.debug.WordPool;

/**
 * @author zaya
 */
public class IteratorSearcher implements Searcher {
    public List<Word> words;

    public IteratorSearcher() {
        words = new WordPool().getWords();
    }

    @Override
    public Word search(String searchingFor) {
        Iterator<Word> iterator = words.iterator();
        while (iterator.hasNext()) {
            Word nextWord = iterator.next();
            System.out.println("here1");
            System.out.println("nextWord: " + nextWord.getWord() + ", searchingFor: " + searchingFor);
            if (nextWord.getWord().equals(searchingFor)) {
                System.out.println("here2");
                return nextWord;
            }
        }
        System.out.println("here");
        throw new IllegalArgumentException("the word you are looking for is not here, word:" + searchingFor);
    }
}
