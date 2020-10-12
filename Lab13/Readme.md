# Book Price & Search System
----

### What I learn at this project:

1. **Companion Object(伴生物件):**
    是屬於某個 class 底下的單一實體, 在 Kotlin 中,取代了 java classs 對應的 static.
    
    > 因為 Kotlin 沒有 `static`, 而是透過不同方法實現, 而需要 static 則首選為 `top level`
    > 如果不適合 `top level`, 則使用 `companion object` + `const`
    > 如果不適合 `companion object`, 則使用  `val` + `@JvmField`
    > `@JvmField`,`@JvmStatic` 不會讓 object 所產生的實體消失
    
2. **lateinit(延遲初始化):**
    lateinit 顧名思義就是延後初始化, 但 lateinit 只能用在會改變的屬性上
    所以只適用在 `var` 一般變數的關鍵字前面, 並不適用在 `val` 類似 final 前
