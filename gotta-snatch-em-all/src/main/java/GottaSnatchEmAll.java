import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {
    Set<String> cards;

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<String>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return !myCollection.isEmpty() && !(theirCollection.containsAll(myCollection) || myCollection.containsAll(theirCollection));
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));

        for (int i = 1; i < collections.size(); i++) {
            Iterator<String> it = common.iterator();
            Set<String> currentSet = collections.get(i);
            while (it.hasNext()) {
                String card = it.next();
                if (!currentSet.contains(card)) {
                    it.remove();
                }
            }
        }

        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();

        for (Set<String> collection : collections) {
            allCards.addAll(collection);
        }

        return allCards;
    }
}
