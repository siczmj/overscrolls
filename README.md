# OverScrolls

(In progress...)

Originally, my goal was building an unique "pull-to-refresh" effects. I thought it can I animate by
overscroll offsets. I was surprised that there is no method that would give it back the overscroll
size. So I created a solution that able to report the size of overscroll.


# Concept

1. Create an OverScrollHelper which following do:
- Handle the touch event and watch the scrolling on Y axis (or maybe X axis).
- Introduce new states (overscroll-start, overscroll, overscroll-end)
- Add a listener to callback when overscroll in progress.
- Calculate overscroll size.

2. User OverScrollHelper on the common scrollable Android views:
- ScrollView --> OverScrollScrollView
- ListView --> OverScrollListView
- ...

3. Create some example to custom overscroll.



## Why good this?
It's a practical tool if you want to build a custom:
- Pull to refresh
- Parallax scroll
- EdgeEffect

