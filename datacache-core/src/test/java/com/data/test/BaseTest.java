package com.data.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.data.context.SpringRootConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
@TransactionConfiguration(defaultRollback = false)
public class BaseTest {


}
