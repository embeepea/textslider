TextSlider
----------

This is a very small sample program that uses react.js to create a
component called a "text slider", which consists of a text field and a
slider coupled together so that changing the value of one of them also
changes the value of the other.

I think this is interesting because it shows how react.js allows
information to flow between components in a clear way that reduces the
confusion over updates and dependencies that usually accompanies more
traditional callback-oriented libraries.

The "information architecture" of this simple application is:

* there is a single application state object containing a `value`
  field which is a number from 0 to 10 (actually, the entire
  application in this case consists of a single instance of the
  TextSlider component, so the state object is contained in that
  component); its initial value is `{value: 8}`
  
* whenever either of the text field or slider is rendered, it's
  rendered with a value taken from this state object
  
* whenever the user changes the value of either the text field
  or the slider, the modified component calls the TextSlider
  components onValueChange function with the updated value, and
  the onValueChange function modifies the component's state
  accordingly, which triggers a re-render of the subcomponents
