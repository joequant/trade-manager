/* ===========================================================
 * TradeManager : a application to trade strategies for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2011-2011, by Simon Allen and Contributors.
 *
 * Project Info:  org.trade
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Oracle, Inc.
 * in the United States and other countries.]
 *
 * (C) Copyright 2011-2011, by Simon Allen and Contributors.
 *
 * Original Author:  Simon Allen;
 * Contributor(s):   -;
 *
 * Changes
 * -------
 *
 */
package org.trade.persistent.dao;

import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestCase;

import org.jfree.data.DataUtilities;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trade.core.valuetype.DAODecode;
import org.trade.core.valuetype.Decode;
import org.trade.core.valuetype.Money;
import org.trade.dictionary.valuetype.ChartDays;
import org.trade.dictionary.valuetype.DAOEntryLimit;
import org.trade.dictionary.valuetype.DAOStrategy;
import org.trade.dictionary.valuetype.DAOStrategyManager;
import org.trade.ui.TradeAppLoadConfig;

/**
 * Some tests for the {@link DataUtilities} class.
 * 
 * @author Simon Allen
 * @version $Revision: 1.0 $
 */
public class ValueTypeDAOTest extends TestCase {

	private final static Logger _log = LoggerFactory
			.getLogger(ValueTypeDAOTest.class);

	/**
	 * Method setUp.
	 * 
	 * @throws Exception
	 */
	protected void setUp() throws Exception {
		TradeAppLoadConfig.loadAppProperties();
	}

	/**
	 * Method tearDown.
	 * 
	 * @throws Exception
	 */
	protected void tearDown() throws Exception {
	}

	@Test
	public void testDOAStrategies() {
		try {
			DAOStrategy strategies = new DAOStrategy();
			Vector<Decode> decodes = strategies.getCodesDecodes();
			Enumeration<Decode> eDecodes = decodes.elements();
			TestCase.assertFalse(decodes.isEmpty());
			while (eDecodes.hasMoreElements()) {
				Decode decode = eDecodes.nextElement();
				_log.info("TYPE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._TYPE));
				_log.info("CODE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._CODE));
				_log.info("DISPLAY_NAME:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._DISPLAY_NAME));

			}

			DAOStrategyManager strategyManagers = new DAOStrategyManager();
			decodes = strategyManagers.getCodesDecodes();
			TestCase.assertFalse(decodes.isEmpty());
			eDecodes = decodes.elements();
			while (eDecodes.hasMoreElements()) {
				Decode decode = eDecodes.nextElement();
				_log.info("TYPE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._TYPE));
				_log.info("CODE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._CODE));
				_log.info("DISPLAY_NAME:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._DISPLAY_NAME));

			}
		} catch (Exception ex) {
			TestCase.fail("Error finding row " + ex.getMessage());
		}
	}

	@Test
	public void testDOAEntryLimit() {
		try {
			DAOEntryLimit entryLimits = new DAOEntryLimit();
			Vector<Decode> decodes = entryLimits.getCodesDecodes();
			TestCase.assertFalse(decodes.isEmpty());
			Enumeration<Decode> eDecodes = decodes.elements();
			while (eDecodes.hasMoreElements()) {
				Decode decode = eDecodes.nextElement();
				_log.info("TYPE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._TYPE));
				_log.info("CODE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._CODE));
				_log.info("DISPLAY_NAME:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._DISPLAY_NAME));

			}
			Money price = new Money(20.22);
			Entrylimit entrylimit = entryLimits.getValue(price);
			_log.info("Price:" + price + " Percent:"
					+ entrylimit.getPercentOfPrice() + " LimitAmount:"
					+ entrylimit.getLimitAmount());

		} catch (Exception ex) {
			TestCase.fail("Error finding row " + ex.getMessage());
		}
	}

	@Test
	public void testChartDays() {
		try {
			ChartDays DAOValues = new ChartDays();
			Vector<Decode> decodes = DAOValues.getCodesDecodes();
			TestCase.assertFalse(decodes.isEmpty());
			Enumeration<Decode> eDecodes = decodes.elements();
			while (eDecodes.hasMoreElements()) {
				Decode decode = eDecodes.nextElement();
				_log.info("TYPE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._TYPE));
				_log.info("CODE:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._CODE));
				_log.info("DISPLAY_NAME:"
						+ decode.getValue(DAODecode.CODE_DECODE_IDENTIFIER
								+ DAODecode._DISPLAY_NAME));
			}
		} catch (Exception ex) {
			TestCase.fail("Error finding row " + ex.getMessage());
		}
	}
}
