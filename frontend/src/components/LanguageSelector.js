import React from 'react';
import {changeLanguage} from "../api/apiCalls";
import {withTranslation} from 'react-i18next';
import Input from "../components/Input";


const LanguageSelector = (props) => {

    const onChangeLanguage = language => {
        const {i18n} = props;
        i18n.changeLanguage(language);
        changeLanguage(language);
    };
    return (
        <div className="container">
            <img src="https://flagsapi.com/tr/flat/24.png"
                 alt="Turkish Flag"
                 onClick={() => onChangeLanguage('tr')}
                 style={{cursor: 'pointer'}}
            />
            <img src="https://flagsapi.com/us/flat/24.png"
                 alt="USA Flag"
                 onClick={() => onChangeLanguage('en')}
                 style={{cursor: 'pointer'}}
            />
        </div>
    );
};

export default withTranslation()(LanguageSelector);