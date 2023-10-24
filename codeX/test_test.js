Feature('My First Test');

Scenario('test something', ({ I }) => {
  I.amOnPage('https://etalente.co.za/');
  I.see('etalente');
});