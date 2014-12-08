var TextInput = React.createClass({
  handleInput: function (e) {
      var value = this.getDOMNode().value.trim();
      this.props.onValueChange(value);
  },
  render: function() {
    return (
        <input type="text" size="1" value={this.props.value} onChange={this.handleInput} />
    );
  }
});

var SliderInput = React.createClass({
  handleInput: function (e) {
      var value = this.getDOMNode().value;
      this.props.onValueChange(value);
  },
  render: function() {
    return (
        <input type="range" min="0" max="10" step="1" value={this.props.value} onInput={this.handleInput} onChange={this.handleInput} />
    );
  }
});

var TextSlider = React.createClass({
  handleValueChange: function(value) {
    this.setState({value: value});
  },
  getInitialState: function() {
    return {value: 8};
  },
  render: function() {
    return (
      <div className="textSlider">
        <TextInput value={this.state.value} onValueChange={this.handleValueChange} />
        <SliderInput value={this.state.value} onValueChange={this.handleValueChange} />
      </div>
    );
  }
});

React.render(
  <TextSlider />,
  document.getElementById('content')
);
