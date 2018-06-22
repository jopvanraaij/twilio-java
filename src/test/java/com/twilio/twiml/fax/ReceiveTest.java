/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.fax;

import com.twilio.http.HttpMethod;
import com.twilio.twiml.GenericNode;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link Receive}
 */
public class ReceiveTest {
    @Test
    public void testEmptyElement() {
        Receive elem = new Receive.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Receive/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Receive elem = new Receive.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CReceive%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Receive elem = new Receive.Builder().action(URI.create("https://example.com")).method(HttpMethod.GET).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Receive action=\"https://example.com\" method=\"GET\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithExtraAttributes() {
        Receive elem = new Receive.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Receive a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        Receive.Builder builder = new Receive.Builder();

        builder.addText("Hey no tags!");

        Receive elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Receive>" +
            "Hey no tags!" +
            "</Receive>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Receive.Builder builder = new Receive.Builder();
        Receive elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Receive>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Receive>",
            elem.toXml()
        );
    }
}