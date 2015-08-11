# Android OverScrolls

(In progress...)

Originally, my goal was building an unique "pull-to-refresh" effects on Android. I thought it can I
animate by overscroll offsets. I was surprised that there is no method that would give it back
the size of overscroll. So I created a solution that able to report it.

# Demo

(comming soon)


# Concept

1. Create an OverScrollHelper which following do:
    - Handle the touch event and watch the scrolling on Y axis (or maybe later X axis).
    - Introduce new states (overscroll-start, overscroll, overscroll-end)
    - Add a listener to callback when overscroll in progress or other state changed.
    - Calculate overscroll size.

2. Use OverScrollHelper on the common scrollable Android views:
    | View          | Overscroll version   |
    | ------------- |:-------------------- |
    | ScrollView    | OverScrollScrollView |
    | ListView      | OverScrollListView   |
    | WebView       | OverScrollWebView    |

3. Implement some custom overscroll example.



## Why good this?
It's a practical tool if you want to build a custom:
- Swipe refresh / Pull to refresh
- Parallax scroll
- EdgeEffect

# Usage

## Download

There is enough to download only the overscrolls-library which contains all neccessary files.

## Add OverScroll[ScrollView|ListView|WebView] to your XML layout

```xml
    <com.nirigo.mobile.view.overscrolls.OverScrollScrollView
        android:id="@+id/scrollview"
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <!-- ScrollView content here -->
    </com.nirigo.mobile.view.overscrolls.OverScrollScrollView>
```

## Find the view and listening to overscroll events

```java
    scrollView = (OverScrollScrollView) findViewById(...);
    scrollView.getOverScroll().setOnOverScrollListener(new OverScrollListener() {
            public void onScroll(ViewGroup parent, int scrollX, int scrollY) {
                // On normal scroll
            }
            public void onOverScrollStart(ViewGroup parent) {
                // On over scroll start
                // Recommended save original state here (height, position, etc.)
            }
            public void onOverScroll(ViewGroup parent, int overscrollX, int overscrollY) {
                // Over scroll in progress...
                // You can change UI element by offset
            }
            public void onOverScrollCancel(ViewGroup parent) {
                // Over scroll ended: release or scroll back to normal
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