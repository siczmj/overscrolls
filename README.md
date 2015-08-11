# Android OverScrolls

(In progress...)

Originally, my goal was building an unique "pull-to-refresh" effects on Android. I thought it can I
animate by overscroll offsets. I was surprised that there is no method that would give it back
the size of overscroll. (correctly) So I created a solution that able to report it.

# Demo

(comming soon)


# Concept

1. Create an OverScrollHelper which following do:
    - Handle the touch event and watch the scrolling on Y axis (or maybe later X axis).
    - Introduce new states (overscroll-start, overscroll, overscroll-end)
    - Add a [listener to callback](https://github.com/siczmj/overscrolls/blob/master/overscrolls-library/src/main/java/com/nirigo/mobile/view/overscrolls/interfaces/OverScrollListener.java) when overscroll in progress or other state changed.
    - Calculate overscroll size.

2. Use OverScrollHelper on the common scrollable Android views:

    | View          | Overscroll version   |
    | ------------- |:-------------------- |
    | ScrollView    | [OverScrollScrollView](https://github.com/siczmj/overscrolls/blob/master/overscrolls-library/src/main/java/com/nirigo/mobile/view/overscrolls/OverScrollScrollView.java) |
    | ListView      | [OverScrollListView](https://github.com/siczmj/overscrolls/blob/master/overscrolls-library/src/main/java/com/nirigo/mobile/view/overscrolls/OverScrollListView.java)   |
    | WebView       | [OverScrollWebView](https://github.com/siczmj/overscrolls/blob/master/overscrolls-library/src/main/java/com/nirigo/mobile/view/overscrolls/OverScrollWebView.java)    |

3. Implement some [custom overscroll](https://github.com/siczmj/overscrolls/tree/master/overscrolls-example/src/main/java/com/nirigo/mobile/overscrolls/examples/overscroll) example.


## Why good this?

It's a practical tool if you want to build an unique:
- Swipe refresh / Pull to refresh
- Parallax scroll
- EdgeEffect

# Usage

## Download

There is enough to download only the overscrolls-library which contains all neccessary files.

## Add OverScroll[...]View to your XML layout

Most common scrollable views prepared to overscroll listening like ScrollView, ListView, WebView, etc....

```xml
    <com.nirigo.mobile.view.overscrolls.OverScrollScrollView
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/scrollview"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <!-- ScrollView content here -->
    </com.nirigo.mobile.view.overscrolls.OverScrollScrollView>
```

## Find view and listening overscroll events

```java
    scrollView = (OverScrollScrollView) findViewById(R.id.scrollview);
    scrollView.getOverScroll().setOnOverScrollListener(new OverScrollListener() {
            public void onScroll(ViewGroup parent, int scrollX, int scrollY) {
                // Report normal scroll
            }
            public void onOverScrollStart(ViewGroup parent) {
                // Over scroll started
                // Recommended save original state here (height, position, etc.)
            }
            public void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY) {
                // Over scroll in progress...
                // You can change UI elements by offset
            }
            public void onOverScrollCancel(ViewGroup parent) {
                // Over scroll ended >> release or scroll back to normal scroll
                // Recommended reset to original state
            }
        });
```

------

# Examples

## OverScroll examples

## Swipe refresh / Pull to refresh examples

*(in progress)*

## Parallax scroll examples

*(in progress)*

## EdgeEffect examples

*(in progress)*


------

# Advanced

## How can I build custom overscroll view?

If you want to create own overscroll view that able to report size of overscroll then you need to
use only OverScrollHelper. This class handle the touch events and calculate overscroll size by
current scroll state. This operation based on [View.getScrollY()](http://developer.android.com/reference/android/view/View.html#getScrollY()).

1. You need to extends your View
2. Make an instance of OverScrollHelper
3. Override the follow events and pass to helper class

    ```java
        public class OverScrollMyView extends MyView{

            private OverScrollHelper overScroll;

            // Constructs and inits here....

            @Override
            public boolean onTouchEvent(@NonNull MotionEvent event) {
                return overScroll.onTouchEvent(event) || super.onTouchEvent(event);
            }

            @Override
            protected void onScrollChanged(int l, int t, int oldl, int oldt) {
                overScroll.onScrollChanged();
                super.onScrollChanged(l, t, oldl, oldt);
            }

            @Override
            protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                overScroll.onSizeChanged(w, h, oldw, oldh);
                super.onSizeChanged(w, h, oldw, oldh);
            }

        }
    ```


## Using custom scroll computing

Sometimes it is necessary to define custom scroll computing. Good example is the ListView or WebView
because to calculate the offset scroll it's complicated. Of course that is implemented by Google but
the standard getScrollY() not working. So I created a listener to customize the computing current
scroll.

```java
    overScroll.setOnOverScrollMeasure(new OverScrollMeasure() {
        public int getScrollY() {
            return computeVerticalScrollOffset(); // accessible from ListView or WebView...
        }
    });
```

------

## TODO

- Overscroll at bottom of view
- Overscroll on horizontal axis (ViewPager or HorizontalScrollView)
- RecycleView support
- More examples
- AAR in maven repo


## License
See the LICENSE file in the project root.