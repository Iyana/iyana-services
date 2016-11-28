/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.iyana.service.mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fgyara
 * @param <K>
 * @param <V>
 */
public class Mock<K,V> {
    
    private final Map<K,V> mockMap = new HashMap();
    
    public K create(K key, V vo) {
        this.mockMap.put(key, vo);
        
        return key;
    }
    
    public void update(K key, V vo) {
        this.mockMap.put(key, vo);
    }
    
    public void delete(K key) {
        this.mockMap.remove(key);
    }
    
    public V find(K key) {
        return this.mockMap.get(key);
    }
    
    public Collection<V> findAll() {
        return this.mockMap.values();
    }
}
