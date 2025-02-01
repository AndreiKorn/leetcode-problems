package com.korn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solution for 
 * <a href="https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/">People Whose List of Favorite Companies Is Not a Subset of Another List</a>
 */
public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Set<Integer>> indexesByCompanies = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (String company : favoriteCompanies.get(i)) {
                Set<Integer> indexes = indexesByCompanies.getOrDefault(company, new HashSet<>());
                indexes.add(i);
                indexesByCompanies.put(company, indexes);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            Set<Integer> temp = null;
            for (String company : favoriteCompanies.get(i)) {
                if (temp == null) {
                    temp = new HashSet<>(indexesByCompanies.get(company));
                } else {
                    temp.retainAll(indexesByCompanies.get(company));
                }
            }
            if (temp != null && temp.size() == 1) {
                result.add(i);
            }
        }

        return result;
    }
}
