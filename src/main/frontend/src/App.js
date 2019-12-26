import React from 'react';
import { Router, Link } from "@reach/router";
import './App.css';
import Checkout from './components/Checkout';
import { Segment, Menu } from 'semantic-ui-react';

const PaymentSuccess = () => <h1 class="ui green label">Your purchase has completed successfully!</h1>
const PaymentFailed = () => <h1 class="ui red label">Your purchase failed!</h1>

function App() {
    return (
        <div className="App">
            <Segment inverted>
                <Menu inverted secondary>
                    <Menu.Item name='checkout' active={true}>
                        <Link to="checkout">Checkout Page</Link>
                    </Menu.Item>
                </Menu>
            </Segment>

            <body>
                <Router>
                    <Checkout path="checkout"></Checkout>
                    <PaymentSuccess path="payment/success" />
                    <PaymentFailed path="payment/fail" />
                </Router>
            </body>
        </div>
    );
}

export default App;
