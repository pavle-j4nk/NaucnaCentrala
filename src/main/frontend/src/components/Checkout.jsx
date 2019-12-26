import React from 'react';
import { Grid, Segment, Image, Rail, Item, Button, Input } from 'semantic-ui-react';

const Checkout = () => {
    const cart = {
        seller: "merchant",
        items: [
            {
                name: "AI article",
                description: "This is wery good article about...",
                price: 4.00
            },
            {
                name: "AI Magazine",
                description: "This is some AI magazine written by...",
                price: 9.99
            }
        ],
        total: 13.99
    };

    const cartItem = item => (
        <Item>
            <Item.Image size='tiny' src='/wireframe.png' />

            <Item.Content>
                <Item.Header as='a'>{item.name}</Item.Header>
                <Item.Meta>Description</Item.Meta>
                <Item.Description>
                    {item.description}
                </Item.Description>
                <Item.Extra>Price: {item.price}</Item.Extra>
            </Item.Content>
        </Item>
    )

    return (
        <Grid centered columns={3}>
            <Grid.Column>
                <Segment>

                    <Item.Group>
                        {
                            cart.items.map(cartItem)
                        }
                    </Item.Group>

                    <Rail position='right'>
                        <Segment>
                            <h3>Total: {cart.total}</h3><br />
                            <form method="POST" action="http://localhost:8080/payment/">
                                <input type="hidden" name="merchant" value={cart.seller} />
                                <input type="hidden" name="amount" value={cart.total}/>
                                <Input type="submit">
                                    <Button >Pay</Button>
                                </Input>
                            </form>
                        </Segment>
                    </Rail>
                </Segment>
            </Grid.Column>
        </Grid>
    );

};


export default Checkout;
