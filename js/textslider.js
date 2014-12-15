var TextSlider = React.createClass({
  handleInput: function (e) {
      this.setState({value: e.target.value});
  },
  getInitialState: function() {
    return {value: 8};
  },
  render: function() {
    return (
      <div className="textSlider">
        <input type="text" size="1" value={this.state.value} onChange={this.handleInput} />
        <input type="range" min="0" max="10" step="1" value={this.state.value}
               onInput={this.handleInput} onChange={this.handleInput} />
      </div>
    );
  }
});

React.render(
  <TextSlider />,
  document.getElementById('content')
);
