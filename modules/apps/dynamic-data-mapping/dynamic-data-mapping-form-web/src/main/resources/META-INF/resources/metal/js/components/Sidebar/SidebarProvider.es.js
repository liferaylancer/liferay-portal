import Component from 'metal-jsx';
import {Config} from 'metal-state';
import {LayoutSupport} from '../Layout/index.es.js';

class SidebarProvider extends Component {
	static PROPS = {
		fieldContext: Config.array(),

		context: Config.array(),

		focusedField: Config.object()
	};

	static STATE = {
		fieldContext: Config.array()
	};

	constructor(props, context) {
		super(props, context);

		this.state.fieldContext = props.fieldContext;
	}

	willReceiveProps(nextProps) {
		if (
			typeof nextProps.context !== 'undefined' &&
			nextProps.context.newVal.length
		) {

			// this._syncContextWithFieldContext();

		}

		if (
			typeof nextProps.fieldContext !== 'undefined' &&
			nextProps.fieldContext.newVal.length
		) {
			this.setState(
				{
					fieldContext: nextProps.fieldContext.newVal
				}
			);
		}
	}

	_syncContextWithFieldContext() {
		const {context, focusedField} = this.props;
		const {columnIndex, pageIndex, rowIndex} = focusedField;

		const field = LayoutSupport.getColumn(
			context,
			pageIndex,
			rowIndex,
			columnIndex
		).fields[0];

		const depth = array => {
			for (let i = 0; i < array.length; i++) {
				const item = array[i];

				if (item.key) {
					const propName = field[item.key] || '';

					item[item.key] = propName;
				}

				if (item.rows && item.rows.length) {
					depth(item.rows);
				}
				else if (item.columns && item.columns.length) {
					depth(item.columns);
				}
				else if (item.fields && item.fields.length) {
					depth(item.fields);
				}
			}

			return array;
		};
	}

	_handleShowChanged(event) {
		this.emit('showChanged', event);
	}

	render() {
		const {children} = this.props;
		const {fieldContext} = this.state;
		const Child = children[0];

		const events = {
			showChanged: this._handleShowChanged.bind(this),
			...Child.props.events
		};

		Object.assign(
			Child.props,
			{...this.props},
			events,
			fieldContext
		);

		return children;
	}
}

export default SidebarProvider;