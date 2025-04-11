import React from 'react';
import './Hero.css';

const Hero = ({ title, img, button = false }) => {
  return (
    <section className='flex-center site-hero'>
      <article className='flex-center container'>
        <div className='flex-column site-hero__left'>
          <div className='flex-column hero-title__container'>
            <h1>{title}</h1>
          </div>
          {button && (
            <a href='' className='flex-center action-btn'>
              Shop Now
              <img src='./arrow.png' alt='arrow icon' />
            </a>
          )}
        </div>
        <div className='flex-center hero-site__right'>
          <img src={img} alt='hero image' />
        </div>
      </article>
    </section>
  );
};

export default Hero;
