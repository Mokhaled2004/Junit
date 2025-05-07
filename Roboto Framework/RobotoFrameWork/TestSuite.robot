*** Variables ***
${passwordforalibaba}    S5y5kFJA@dkkxqR
${emailforalibaba}    rodyamrroro@gmail.com
${URL}            https://ar.aliexpress.com/

*** Settings ***
Library           SeleniumLibrary

*** Test Cases ***
ProductSearch
    Open Browser    ${URL}    chrome
    Wait Until Element Is Visible    //div[contains(text(), "Don't allow")]    timeout=10s
    Click Element    //div[contains(text(), "Don't allow")]
    Wait Until Element Is Visible    //input[@id='search-words']    timeout=20s
    Input Text    //input[@id='search-words']    smart watch
    Click Element    //input[@type='button' and @title='submit']
    Sleep    3s

FilterByCategory
    Wait Until Element Is Visible    //span[@class='i0_ae' and contains(text(), 'السعر')]    timeout=10s
    Input Text    //input[@name='minPrice']    500
    Input Text    //input[@name='maxPrice']    1500
    Click Element    //span[contains(text(), 'OK')]
    Sleep    5s

AddItemToCart
    Wait Until Element Is Visible    //span[@class='mk_a8']    timeout=10s
    Click Element    //span[@class='mk_a8']
    Wait Until Element Is Visible    //div[@class='mini--wrap--Bdmhj4T']    timeout=100s
    Sleep    20s
    Wait Until Element Is Visible    //button[contains(@class, 'add-to-cart--addtocart')]    timeout=10s
    Click Element    //button[contains(@class, 'add-to-cart--addtocart')]
    Sleep    5s

ViewCart
    Wait Until Element Is Visible    //div[contains(@class, 'shop-cart--menuItem')]//a    timeout=10s
    Sleep    2s
    Click Element    //div[contains(@class, 'shop-cart--menuItem')]//a
    Close Browser

ChangeLanguage
    Open Browser    ${URL}    chrome
    Wait Until Element Is Visible    //div[contains(@class, 'Sk1_X') and contains(text(), "Don't allow")]
    Click Element    //div[contains(@class, 'Sk1_X') and contains(text(), "Don't allow")]
    Wait Until Element Is Visible    //div[contains(@class, 'ship-to--menuItem')]//span\n
    Click Element    //div[contains(@class, 'ship-to--menuItem')]//span\n
    Wait Until Element Is Visible    //div[contains(@class, 'select--text--1b85oDo') and .//span[text()='العربية']]
    Click Element    //div[contains(@class, 'select--text--1b85oDo') and .//span[text()='العربية']]
    Wait Until Element Is Visible    //div[contains(@class, 'select--item--32FADYB') and text()='English']
    Click Element    //div[contains(@class, 'select--item--32FADYB') and text()='English']
    Click Element    //div[contains(@class, 'es--saveBtn')]
    Sleep    5
    Close Browser

UserLogin
    Open Browser    ${URL}    chrome
    Wait Until Element Is Visible    //input[@name='email']    timeout=10s
    Input Text    //input[@name='email']    ${emailforalibaba}
    Input Text    //input[@name='password']    ${passwordforalibaba}
    Click Button    //button[@type='submit']
    Wait Until Element Is Visible    //div[@class='user-profile']    timeout=10s
    Close Browser

ChangeCurrency
    Open Browser    ${URL}    chrome
    Wait Until Element Is Visible    //div[contains(@class, 'Sk1_X') and contains(text(), "Don't allow")]
    Click Element    //div[contains(@class, 'Sk1_X') and contains(text(), "Don't allow")]
    Wait Until Element Is Visible    //div[contains(@class, 'ship-to--menuItem')]//span\n
    Click Element    //div[contains(@class, 'ship-to--menuItem')]//span\n
    sleep    5
    Wait Until Element Is Visible    //div[contains(@class, 'select--text--1b85oDo')]//span[text()='EGP ( الجنيه المصري )']
    Click Element    //div[contains(@class, 'select--text--1b85oDo')]//span[text()='EGP ( الجنيه المصري )']
    Wait Until Element Is Visible    //div[contains(@class, 'select--item--32FADYB') and text()='USD ( الدولار الأمريكي )']
    Click Element    //div[contains(@class, 'select--item--32FADYB') and text()='USD ( الدولار الأمريكي )']
    Click Element    //div[contains(@class, 'es--saveBtn')]
    Sleep    20
    Close Browser

ZoomProductImages
    Open Browser    https://ar.aliexpress.com/item/1005006661389627.html?spm=a2g0o.tm1000009216.d13.1.63232ee9cgldYZ&sourceType=561&pvid=1462827a-2e94-4da1-8fa3-a1a932e32d2b&pdp_ext_f=%7B%22ship_from%22:%22CN%22,%22sku_id%22:%2212000037952537330%22%7D&scm=1007.28480.425796.0&scm-url=1007.28480.425796.0&scm_id=1007.28480.425796.0&pdp_npi=4%40dis%21EGP%21EGP%2017.92%21EGP%2010.37%21%21%212.35%211.36%21%40212e532617456935422247844ede85%2112000037952537330%21gsd%21EG%21%21&channel=sd&aecmd=true&_gl=1*28kf47*_gcl_au*MTg0NTE1Mzk2MC4xNzQ1NjkzNzc0*_ga*MTAxOTIwODE5NS4xNzQ1NjkzNzc0*_ga_VED1YSGNC7*MTc0NTY5Mzc3NS4xLjEuMTc0NTY5Mzc3Ni41OS4wLjA    chrome
    Wait Until Page Does Not Contain    //iframe[contains(@src, 'https://www.google.com/recaptcha/')]
    sleep    20
    Wait Until Element Is Visible    //img[contains(@src, 'S8296656469b34699bfdf91980af6d6895')]
    Mouse Over    //img[contains(@src, 'S8296656469b34699bfdf91980af6d6895')]
    Wait Until Element Is Visible    //div[contains(@class, 'magnifier--behiver')]
    Mouse Over    //div[contains(@class, 'magnifier--behiver')]
    sleep    5
    Click Element    //div[contains(@class, 'magnifier--behiver')]
    sleep    5
    Close Browser

ChangeShippingDestinationCountry
    Open Browser    ${URL}    chrome
    Wait Until Element Is Visible    //div[contains(@class, 'Sk1_X') and contains(text(), "Don't allow")]
    Click Element    //div[contains(@class, 'Sk1_X') and contains(text(), "Don't allow")]
    Wait Until Element Is Visible    //div[contains(@class, 'ship-to--menuItem')]//span\n
    Click Element    //div[contains(@class, 'ship-to--menuItem')]//span\n
    Wait Until Element Is Visible    //div[contains(@class, 'select--text--')]
    Click Element    //div[contains(@class, 'select--text--')]
    Wait Until Element Is Visible    //div[contains(@class, 'select--item--')]
    Click Element    //div[contains(@class, 'select--item--')]
    Click Element    //div[contains(@class, 'es--saveBtn')]
    sleep    5
    Close Browser

RemovePopUp
    Open Browser    ${URL}    chrome
    Wait Until Element Is Visible    //div[contains(text(), "Don't allow")]    timeout=10s
    Click Element    //div[contains(text(), "Don't allow")]
    Sleep    10s
    Close Browser
