# Map

## ( 1 ) Map

💡 `<K key, V value>` 형태로 값을 저장하는 인터페이스

- 순서가 없고, key의 중복을 허용하지 않는다.
- Collection을 상속받지 않는다.

### 1 ) 주요 method

1. `put(K key, V value)`
    - key와 값을 맵에 저장 한다.
    - **key가 존재하면 새 값으로 대체된다.**
2. `get(Object key)`
    - 지정된 key에 대응하는 값을 반환하다.
    - **key에 대응하는 값이 없으면 null을 반환한다.**
3. `replace(K key, V value)`
    - 지정된 key에 대응하는 값을 새 값으로 대체한다.
    - **key에 대응하는 값이 없으면 아무 일도 일어나지 않는다.**
4. `remove(Object key)`
    - key와 그에 대응하는 값을 제거한다.
    - **key에 대응하는 값이 없으면 아무 일도 일어나지 않는다.**
5. `containsKey(Object key)`
    - Map에  지정된 key가 존재하는지 여부를 boolean으로 반환한다.
6. `containsValue(Object value)`
    - Map에  지정된 value가 존재하는지 여부를 boolean으로 반환한다.
7. `size()`
    - Map에 저장된 key-value 쌍의 개수를 반환한다.
8. `clear()`
    - Map에 저장된 모든것을 지운다.
9. `keySet()`
    - Map의 모든 key를 Set 객체로 반환한다.
    
    ```java
    Set<Integer> keySet = map.keySet(); // Set<Type>에서 Type은 key의 타입
           
    for (Integer key : keySet) {            
    		System.out.println(key + " : " + map.get(key));        
    }
    ```
    
10. `entrySet()`
    - Map에서 모든 Entry(Key-Value 쌍)를 Set 객체로 반환한다.
    
    ```java
    Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); // Set<Type>에서 Type은 Map.Entry<K, V>
           
    for (Map.Entry<String, Integer> entry : entrySet) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    ```
    
11. `values()`
    - Map의 모든 value를 Collection으로 반환한다.
    
    ```java
    Collection<String> values = map.values(); // Collection<Type>에서 Type은 key의 타입
    
    for (String value : values) {
    		System.out.println("value: " + value);
    }
    ```
    

### 2 ) 정렬

1. key 값에 대해 정렬
    
    ```java
    Map<String, Integer> map = new HashMap<>();
    
    map.put("A", 10);
    map.put("D", 30);
    map.put("C", 20);
    map.put("B", 40);
    
    // keySet을 List로 반환
    List<String> keySet = new ArrayList<>(map.keySet());
    
    // key 값으로 오름차순 정렬
    Collections.sort(keySet);
    
    for (String key : keySet) {
         System.out.print("Key : " + key);
         System.out.println(", Val : " + map.get(key));
    }
           
    /*  결과
        Key : A, Val : 10
        Key : B, Val : 40
        Key : C, Val : 20
        Key : D, Val : 30
    */
            
    // key 값으로 내림차순 정렬
    Collections.reverse(keySet);
    
    for (String key : keySet) {
         System.out.print("Key : " + key);
         System.out.println(", Val : " + map.get(key));
    }
            
    /*  결과
        Key : D, Val : 30
        Key : C, Val : 20
        Key : B, Val : 40
        Key : A, Val : 10
    */
    ```
    
2. value 값에 대해 정렬
    
    ```java
    List<String> keySet = new ArrayList<>(map.keySet());
    
    // value 값으로 오름차순 정렬
    Collections.sort(keySet, new Comparator<String>() {
    		@Override
        public int compare(String o1, String o2) {
             return map.get(o1).compareTo(map.get(o2));
        }
    });
    
    for (String key : keySet) {
         System.out.print("Key : " + key);
         System.out.println(", Val : " + map.get(key));
    }
    
    /*  결과
        Key : A, Val : 10
        Key : C, Val : 20
        Key : D, Val : 30
        Key : B, Val : 40
    */
    
    // value 값으로 내림차순 정렬
    // 위 comparator 람다 표현식으로
    keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
    
    // 또는
    Collections.sort(keySet, (o1, o2) -> map.get(o2) - hashMap.get(o1));
    
    for (String key : keySet) {
         System.out.print("Key : " + key);
         System.out.println(", Val : " + map.get(key));
    }
    
    /* 결과
       Key : B, Val : 40
       Key : D, Val : 30
       Key : C, Val : 20
       Key : A, Val : 10
    */
    ```
    
    - 두 객체를 빼는 것 보다 compareTo가 더 빠르다.

## ( 2 ) HashMap

<aside>
💡 Map인터페이스를 구현한 대표적인 클래스

- 삽입되는 순서와 저장되는 위치는 관계가 없다.
</aside>

## ( 3 ) TreeMap

<aside>
💡 객체를 정렬하여 저장하는 이진트리 형태 구조의 클래스

- 저장과 동시에 key 값에 대하여 오름차순으로 정렬된다.
- 정렬 후 저장하기 때문에 HashMap보다 데이터 추가, 삭제에 시간이 더 걸린다.
    
    → 정렬과 범위 검색에 유리
    
- key가 Comparable을 구현하고 있지 않을 경우, 저장하는 순간 ClassCastException이 발생한다.
</aside>