import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {
  createTransaction,
  getTransaction
} from "../../actions/transactionActions";
import classnames from "classnames";

class UpdateTransaction extends Component {
  constructor() {
    super();
    this.state = {
      transactionType: "",
      cryptoCurrency: "",
      units: "",
      transactionCurrency: "",
      transactionPrice: "",
      eurosTransactionCurrencyRate: "",
      transactionDate: "",
      exchangeWeb: "",
      errors: {}
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getTransaction(id, this.props.history);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
    const {
      id,
      transactionType,
      cryptoCurrency,
      units,
      transactionCurrency,
      transactionPrice,
      eurosTransactionCurrencyRate,
      transactionDate,
      exchangeWeb
    } = nextProps.transaction;

    this.setState({
      id,
      transactionType,
      cryptoCurrency,
      units,
      transactionCurrency,
      transactionPrice,
      eurosTransactionCurrencyRate,
      transactionDate,
      exchangeWeb
    });
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newTransaction = {
      id: this.state.id,
      transactionType: this.state.transactionType,
      cryptoCurrency: this.state.cryptoCurrency,
      units: this.state.units,
      transactionCurrency: this.state.transactionCurrency,
      transactionPrice: this.state.transactionPrice,
      eurosTransactionCurrencyRate: this.state.eurosTransactionCurrencyRate,
      transactionDate: this.state.transactionDate,
      exchangeWeb: this.state.exchangeWeb
    };
    this.props.createTransaction(newTransaction, this.props.history);
  }

  render() {
    const { errors } = this.state;
    return (
      <div>
        <div className="transaction">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Add Transaction form</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.transactionType
                      })}
                      placeholder="Transaction Type"
                      name="transactionType"
                      value={this.state.transactionType}
                      onChange={this.onChange}
                    />
                    {errors.investmentType && (
                      <div className="invalid-feedback">
                        {errors.transactionType}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.cryptoCurrency
                      })}
                      placeholder="CryptoCurrency Type"
                      name="cryptoCurrency"
                      value={this.state.cryptoCurrency}
                      onChange={this.onChange}
                    />
                    {errors.cryptoCurrency && (
                      <div className="invalid-feedback">
                        {errors.cryptoCurrency}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.units
                      })}
                      placeholder="Units"
                      name="units"
                      value={this.state.units}
                      onChange={this.onChange}
                    />
                    {errors.units && (
                      <div className="invalid-feedback">{errors.units}</div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.transactionPrice
                      })}
                      placeholder="Transaction Price"
                      name="transactionPrice"
                      value={this.state.transactionPrice}
                      onChange={this.onChange}
                    />
                    {errors.transactionPrice && (
                      <div className="invalid-feedback">
                        {errors.transactionPrice}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.transactionCurrency
                      })}
                      placeholder="Transaction Currency"
                      name="transactionCurrency"
                      value={this.state.transactionCurrency}
                      onChange={this.onChange}
                    />
                    {errors.transactionCurrency && (
                      <div className="invalid-feedback">
                        {errors.transactionCurrency}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.eurosTransactionCurrencyRate
                      })}
                      placeholder="Transaction Currency Rate"
                      name="transactionCurrency"
                      value={this.state.eurosTransactionCurrencyRate}
                      onChange={this.onChange}
                    />
                    {errors.eurosTransactionCurrencyRate && (
                      <div className="invalid-feedback">
                        {errors.transactionCeurosTransactionCurrencyRateurrency}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.exchangeWeb
                      })}
                      placeholder="Exchange Web"
                      name="exchangeWeb"
                      value={this.state.exchangeWeb}
                      onChange={this.onChange}
                    />
                    {errors.exchangeWeb && (
                      <div className="invalid-feedback">
                        {errors.exchangeWeb}
                      </div>
                    )}
                  </div>
                  <h6>Transaction Date</h6>
                  <div className="form-group">
                    <input
                      type="date"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.transactionDate
                      })}
                      name="transactionDate"
                      value={this.state.transactionDate}
                      onChange={this.onChange}
                    />
                    {errors.price && (
                      <div className="invalid-feedback">
                        {errors.transactionDate}
                      </div>
                    )}
                  </div>

                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

UpdateTransaction.propTypes = {
  getTransaction: PropTypes.func.isRequired,
  transaction: PropTypes.object.isRequired,
  createTransaction: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  transaction: state.appTransaction.transaction,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { getTransaction, createTransaction }
)(UpdateTransaction);
